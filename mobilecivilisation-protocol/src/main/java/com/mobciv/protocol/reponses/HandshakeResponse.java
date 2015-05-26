package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class HandshakeResponse extends Message {

	public static int RESPONSE_ID = 0x0001 + Message.RESPONSE;
	
	public HandshakeResponse(String playerID, int civilisationID){
		super(RESPONSE_ID, playerID, civilisationID, MessageType.HANDSHAKE);
	}

}
