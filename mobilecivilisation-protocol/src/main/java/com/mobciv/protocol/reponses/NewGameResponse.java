package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class NewGameResponse extends Message {

	NewGameResponse(String playerID, int civilisationID) {
		super(playerID, civilisationID, MessageType.NEW_GAME);
	}

}
