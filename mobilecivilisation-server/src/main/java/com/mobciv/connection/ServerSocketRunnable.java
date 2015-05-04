package com.mobciv.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.mobciv.Log.Log;

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
	
	protected ServerSocketRunnable() {
		Log.logger().log(TAG, "New server socket created");
	}

	@Override
	public void run() {		
		isRunning = true;
		Log.logger().log(TAG, "Server thread state: running");
		while (isRunning) {
			
		}
		Log.logger().log(TAG, "Server thread state: " + (isRunning ? "Should be running" : "Finishing"));
	}
	
	public synchronized static ServerSocketRunnable getInstance() {
		if (instance == null) {
			instance = new ServerSocketRunnable();
			instance.initialize();
		}		
		return instance;
	}

	private void initialize() {
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
				Log.logger().log(TAG, "Socket closed");
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
