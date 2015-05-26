package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class NewGameRequest extends Message {
	
	public static int REQUEST_ID = 0x0002 + Message.REQUEST;
	
	public NewGameRequest(String playerID, int civilisationID){
		super(REQUEST_ID, playerID, civilisationID,MessageType.NEW_GAME);
	}

}
