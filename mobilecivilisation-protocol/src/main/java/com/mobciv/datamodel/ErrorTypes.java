package com.mobciv.datamodel;

public enum ErrorTypes {
	REQ_NOT_HANDLED(0x01, null);
	
	private int errorCode;
	private String message;
	
	
	private ErrorTypes(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public String getMessage() {
		return message;
	}
	
	
}
