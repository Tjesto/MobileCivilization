package com.mobciv;

import java.io.IOException;

import com.mobciv.Log.Log;
import com.mobciv.connection.ServerSocketRunnable;
import com.mobciv.handlers.Command;
import com.mobciv.handlers.ServerSteeringCommandFilter;
import com.mobciv.handlers.ServersUncoughtExceptionHandler;
import com.mobciv.handlers.StopCommandFilter;

public final class Starter {
	private static final String TAG = Starter.class.getName();
	
	private static volatile boolean isRunning;

	public static void main(String[] args) {
		Log logger = Log.logger();
		logger.log(TAG, "Starting sequence started");
		Thread.currentThread().setUncaughtExceptionHandler(
				new ServersUncoughtExceptionHandler(Thread.currentThread()
						.getUncaughtExceptionHandler()));
		logger.log(TAG, "Server uncaught exceptions handler set");
		logger.log(TAG, "Starting server socket");
		Thread serverThread = new Thread(ServerSocketRunnable.getInstance());
		logger.log(TAG, "Server socket thread prepared");
		serverThread.start();
		logger.log(TAG, "Server socket thread started");
		ServerSteeringCommandFilter commandFilter = new StopCommandFilter();
		logger.log(TAG, "Command filters created");
		isRunning = true;		
		logger.log(TAG, "Starting sequence finished: SUCCESSFUL");
		while (isRunning) {
			byte[] commandBytes;
			try {
				commandBytes = new byte[System.in.available()];
				int readBytes = System.in.read(commandBytes);			
				if (readBytes <= 0) {
					continue;
				}
				String command = new String(commandBytes, 0, readBytes);
				command = command.replaceAll("\r\n", "");
				logger.log(TAG, "Received new command: " + command);
				executeCommand(commandFilter.handle(command));
			} catch (IOException e) {
				logger.log(TAG, "Error in reciving steering command");
				e.printStackTrace(logger.getPrintWriter());
			}
			
		}
		logger.log(TAG, "Finishing");
		finish();
	}

	private static void executeCommand(Command handle) {
		switch (handle) {
		case STOP:
			isRunning = (boolean) handle.getValue();
			Log.logger().log(TAG, "Stop command, finishing sequence started");
			break;
			
		case NONE:
			Log.logger().log(TAG, "Command not specified");
			break;

		default:
			Log.logger().log(TAG, "Command not recognized");
			break;
		}
		
	}

	private static void finish() {
		
		ServerSocketRunnable.getInstance().finish();
		Log.logger().log(TAG, "Server socket thread stopped");
		Log.logger().close();
	}		

}
