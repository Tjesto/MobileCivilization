package com.mobciv.protocol;

public class HandshakeMessage extends Message implements java.io.Serializable{

	HandshakeMessage(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HANDSHAKE);
	}

}
