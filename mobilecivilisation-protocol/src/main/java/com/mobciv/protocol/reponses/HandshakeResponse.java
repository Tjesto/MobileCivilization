package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class HandshakeResponse extends Message {

	public HandshakeResponse(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HANDSHAKE);
	}

}
