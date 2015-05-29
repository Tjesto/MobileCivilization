package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.AbstractResponse;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class NewGameResponse extends AbstractResponse {
	
	public static int RESPONSE_ID = 0x0002 + Message.RESPONSE;

	public NewGameResponse(String playerID, int civilisationID) {
		super(RESPONSE_ID, playerID, civilisationID, MessageType.NEW_GAME);
	}

}
