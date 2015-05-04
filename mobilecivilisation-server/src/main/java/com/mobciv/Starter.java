package com.mobciv;

import com.mobciv.Log.Log;
import com.mobciv.handlers.ServersUncoughtExceptionHandler;

public final class Starter {
	private static final String TAG = Starter.class.getName();

	public static void main(String[] args) {
		Log logger = Log.logger();
		logger.log(TAG, "Starting sequence started");
		Thread.currentThread().setUncaughtExceptionHandler(
				new ServersUncoughtExceptionHandler(Thread.currentThread()
						.getUncaughtExceptionHandler()));
		logger.log(TAG, "Server uncaught exceptions handler set");
		
		logger.close();
	}		

}
