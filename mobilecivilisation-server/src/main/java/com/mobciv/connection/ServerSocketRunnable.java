package com.mobciv.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.JsonSerializer;
import com.mobciv.protocol.handlers.AbstractRequestHandler;
import com.mobciv.protocol.handlers.RequestHandlersFactory;

public class ServerSocketRunnable implements Runnable {
	
	public interface OnEmergencyStopListener {
		void onEmergencyStop();
	}
	
	private static final String TAG = ServerSocketRunnable.class.getName();
	
	private static final int PORT_NUMBER = 1702;
	
	private volatile boolean isRunning;
	
	private volatile static ServerSocketRunnable instance;
	
	private final List<OnEmergencyStopListener> listeners = new ArrayList<>();
	
	private ServerSocket serverSocket;  
	
    private Socket clientSocket;
    
    private List<String> clients = new ArrayList<>();

	private AbstractRequestHandler requestHandler;
    
    private volatile static long id = 0;
	
	protected ServerSocketRunnable() {
		Log.logger().log(TAG, "New server socket created");
	}		

	@Override
	public void run() {		
		isRunning = true;
		Log.logger().log(TAG, "Server thread state: running");
		while (isRunning) {
			try {
				Log.logger().log(
						TAG,
						"Waiting for clients...");
				clientSocket = serverSocket.accept();
				handleMessage();
				String client = clientSocket.getInetAddress().toString() + ":" + "L:" + clientSocket.getLocalPort();
				if (!clients.contains(client)) {
					clients.add(client);
				}
				Log.logger().log(
						TAG,
						"Client registered: "
								+ client);
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace(Log.logger().getPrintWriter());
			}
			
		}
		Log.logger().log(TAG, "Server thread state: " + (isRunning ? "Should be running" : "Finishing"));
	}

	private void handleMessage() throws IOException {
		PrintWriter outStream = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		//TODO
		String request = inStream.readLine();
		if (request != null) {			
			this.requestHandler.handleRequest(request);
			Log.logger().log(TAG, "Received request: " + request);			
			outStream.println(request + " received");
			outStream.flush();
			if (request.contains("stop")) {
				emergencyFinish();
			}
			if (request.contains("CLIENT_EXIT")) {
				clients.remove(clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort() + "L:" + clientSocket.getLocalPort());
				Log.logger().log(
						TAG,
						"Client removed: "
								+ clientSocket.getInetAddress().toString()
								+ ":" + clientSocket.getPort());
			}
		}
	}
	
	public synchronized static ServerSocketRunnable getInstance() {
		if (instance == null) {
			instance = new ServerSocketRunnable();
			instance.initialize();
		}		
		return instance;
	}

	private void initialize() {
		this.requestHandler = RequestHandlersFactory.create();
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
			Log.logger().log(
					TAG,
					"Socket opened on IP "
							+ serverSocket.getInetAddress().toString()
							+ " port " + serverSocket.getLocalPort());
		} catch (IOException e) {
			Log.logger().log(TAG, "Socket not opened");
			e.printStackTrace(Log.logger().getPrintWriter());
			serverSocket = null;
			emergencyFinish();
		}
		
	}

	private void emergencyFinish() {
		Log.logger().log(TAG, "Server thread emergency stop");
		finish();		
		for (OnEmergencyStopListener listener : listeners) {
			listener.onEmergencyStop();
		}
	}

	public synchronized void finish() {		
		isRunning = false;
		if (serverSocket != null) {
			try {
				serverSocket.close();
				Log.logger().log(TAG, "Server Socket closed");
			} catch (IOException e) {
				Log.logger().log(TAG, "Unexpected error in closing socket");
				e.printStackTrace(Log.logger().getPrintWriter());
			}
		}
		Log.logger().log(TAG, "Server thread turned off");
		
	}
	
	public void addListener(OnEmergencyStopListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(OnEmergencyStopListener listener) {
		listeners.remove(listener);
	}

}
