package com.mobciv.protocol;

public class JoinGameRequest extends Message implements java.io.Serializable{
	JoinGameRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.JOIN_GAME);
	}
}
