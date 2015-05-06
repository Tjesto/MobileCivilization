package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class HandshakeRequest extends Message {

	public HandshakeRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HANDSHAKE);
	}

}
