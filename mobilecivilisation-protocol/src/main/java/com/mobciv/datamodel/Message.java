package com.mobciv.datamodel;

public abstract class Message implements JsonSerializable {

	public static final int REQUEST = 0x1000;
	public static final int RESPONSE = 0x2000;
		
	private final String playerID;
	private final int civilisationID;
	private final MessageType type;		
	
	public abstract int getPacketId();	
	
	public String getPlayerID() {
		return playerID;
	}
	public int getCivilisationID() {
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
	
	@Deprecated
	public Message(int requestId, String playerID, int civilisationID,MessageType type){		
		this (playerID, civilisationID, type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Message)) {
			return false;
		}
		Message m = (Message) obj;
		return m.playerID.equals(playerID) && m.civilisationID == civilisationID && type == m.type;
		
	}
	
}
