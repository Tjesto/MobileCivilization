package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class JoinGameResponse extends Message implements java.io.Serializable{
	JoinGameResponse(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.JOIN_GAME);
	}
}
