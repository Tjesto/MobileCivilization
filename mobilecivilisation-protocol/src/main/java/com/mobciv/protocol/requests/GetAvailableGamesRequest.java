package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class GetAvailableGamesRequest extends Message {
	
	public static int REQUEST_ID = 0x0004 + Message.REQUEST;

	public GetAvailableGamesRequest(String playerID) {
		super(REQUEST_ID, playerID, Integer.MIN_VALUE, MessageType.HEARTBEAT);		
	}

}
