package com.mobciv.protocol;

public class HandshakeRequest extends Message implements java.io.Serializable{

	HandshakeRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HANDSHAKE);
	}

}
