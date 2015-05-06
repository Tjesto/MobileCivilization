package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class JoinGameRequest extends Message{
	JoinGameRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.JOIN_GAME);
	}
}
