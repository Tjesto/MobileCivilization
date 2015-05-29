package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.AbstractResponse;
import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class JoinGameResponse extends AbstractResponse {
	
	public static int RESPONSE_ID = 0x0003 + Message.RESPONSE;
	
	public JoinGameResponse(String playerID, int civilisationID){
		super(RESPONSE_ID, playerID, civilisationID,MessageType.JOIN_GAME);
	}
}
