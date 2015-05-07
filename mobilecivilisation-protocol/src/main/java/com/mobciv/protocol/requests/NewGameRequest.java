package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class NewGameRequest extends Message {
	
	public NewGameRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.NEW_GAME);
	}

}
