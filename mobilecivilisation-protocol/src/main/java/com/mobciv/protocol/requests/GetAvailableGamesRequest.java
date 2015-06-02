package com.mobciv.protocol.requests;

import com.mobciv.datamodel.AbstractRequest;
import com.mobciv.datamodel.Message;

public class GetAvailableGamesRequest extends AbstractRequest {
	
	public static int REQUEST_ID = 0x0004 + Message.REQUEST;

	public GetAvailableGamesRequest(String playerID) {
		super(REQUEST_ID, playerID);		
	}

}
