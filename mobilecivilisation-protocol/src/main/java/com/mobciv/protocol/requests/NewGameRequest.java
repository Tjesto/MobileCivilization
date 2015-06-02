package com.mobciv.protocol.requests;

import com.mobciv.datamodel.AbstractRequest;
import com.mobciv.datamodel.Message;

public class NewGameRequest extends AbstractRequest {
	
	public static int REQUEST_ID = 0x0002 + Message.REQUEST;
	private final String roomId;
	
	public NewGameRequest(String playerID, String roomId){
		super(REQUEST_ID, playerID);
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

}
