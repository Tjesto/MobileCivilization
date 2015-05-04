package com.mobciv.handlers;

import java.lang.Thread.UncaughtExceptionHandler;

import com.mobciv.Log.Log;

public class ServersUncoughtExceptionHandler implements UncaughtExceptionHandler {

	private UncaughtExceptionHandler defaultHandler;
	
	public ServersUncoughtExceptionHandler(UncaughtExceptionHandler defaultHandler) {
		this.defaultHandler = defaultHandler;		
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		e.printStackTrace(Log.logger().getPrintWriter());
		defaultHandler.uncaughtException(t, e);
	}

}
