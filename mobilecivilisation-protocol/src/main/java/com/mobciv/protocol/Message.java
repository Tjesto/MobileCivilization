package com.mobciv.protocol;

public class Message implements java.io.Serializable{

	private String playerID;
	private int civilisationID;
	private MessageType type;

	public String getPlayerID() {
		return playerID;
	}
	public int getCivilisationIDID() {
		return civilisationID;
	}
	public MessageType getType() {
		return type;
	}

	public Message(String playerID, int civilisationID,MessageType type){
		this.playerID = playerID;
		this.civilisationID = civilisationID;
		this.type = type;
	}
	
	
}
