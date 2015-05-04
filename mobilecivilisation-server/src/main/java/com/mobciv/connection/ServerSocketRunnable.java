package com.mobciv.connection;

import com.mobciv.Log.Log;

public class ServerSocketRunnable implements Runnable {
	
	private static final String TAG = ServerSocketRunnable.class.getName();
	
	private volatile boolean isRunning;
	
	private volatile static ServerSocketRunnable instance;
	
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
		}		
		return instance;
	}

	public synchronized void finish() {		
		isRunning = false;
		Log.logger().log(TAG, "Server thread turned off");
	}
	
	
}
