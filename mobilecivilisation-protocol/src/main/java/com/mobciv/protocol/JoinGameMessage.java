package com.mobciv.protocol;

public class JoinGameMessage extends Message implements java.io.Serializable{
	JoinGameMessage(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.JOIN_GAME);
	}
}
