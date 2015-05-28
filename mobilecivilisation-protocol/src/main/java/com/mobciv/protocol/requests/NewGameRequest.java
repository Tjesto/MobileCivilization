package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class NewGameRequest extends Message {
	
	public static int REQUEST_ID = 0x0002 + Message.REQUEST;
	private final String roomId;
	
	public NewGameRequest(String playerID, int civilisationID, String roomId){
		super(REQUEST_ID, playerID, civilisationID,MessageType.NEW_GAME);
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

}
