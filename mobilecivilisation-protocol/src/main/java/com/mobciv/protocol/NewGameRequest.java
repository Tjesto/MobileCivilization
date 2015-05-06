package com.mobciv.protocol;

public class NewGameRequest extends Message implements java.io.Serializable{
	
	NewGameRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.NEW_GAME);
	}

}
