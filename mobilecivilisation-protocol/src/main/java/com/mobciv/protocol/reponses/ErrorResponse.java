package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.ErrorTypes;
import com.mobciv.datamodel.JsonSerializable;

public class ErrorResponse implements JsonSerializable {

	private final Integer errorCode;
	
	private final String message;
	
	public ErrorResponse(ErrorTypes errorType) {
		this(errorType.getErrorCode(), errorType.getMessage());
	}
	
	public ErrorResponse(ErrorTypes errorType, String comment) {
		this(errorType.getErrorCode(), comment);
	}
	
	public ErrorResponse(Integer errorCode) {
		this(errorCode, null);
	}
	
	public ErrorResponse(Integer errorCode, String message) {
		if (errorCode == null) {
			throw new NullPointerException();
		}
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
}
