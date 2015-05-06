package com.mobciv.protocol;

public class NewGameMessage extends Message implements java.io.Serializable{
	
	NewGameMessage(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.NEW_GAME);
	}

}
