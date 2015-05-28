package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class JoinGameRequest extends Message{
	
	public static int REQUEST_ID = 0x0003 + Message.REQUEST;
	private final String roomId;
	
	public JoinGameRequest(String playerID, int civilisationID, String roomId){
		super(REQUEST_ID, playerID, civilisationID,MessageType.JOIN_GAME);
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}
}
