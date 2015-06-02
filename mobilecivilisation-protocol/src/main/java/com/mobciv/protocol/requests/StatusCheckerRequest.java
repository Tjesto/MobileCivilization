package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;

public class StatusCheckerRequest extends FromGameRequest {
	
	public static int REQUEST_ID = 0x000 + Message.REQUEST;		
	
	private final long timestamp;

	public StatusCheckerRequest(String playerID, int civilisationID, long timestamp){
		super(REQUEST_ID, playerID, civilisationID);
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}
}
