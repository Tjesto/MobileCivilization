package com.mobciv.datamodel;

public abstract class Message implements JsonSerializable {

	public static final int REQUEST = 0x1000;
	public static final int RESPONSE = 0x2000;
		
	private final String playerID;
	@Deprecated
	private int civilisationID;
	
	@Deprecated
	private MessageType type;		
	
	public abstract int getPacketId();	
	
	public String getPlayerID() {
		return playerID;
	}
	
	@Deprecated
	public int getCivilisationID() {
		return civilisationID;
	}
	
	@Deprecated
	public MessageType getType() {
		return type;
	}
	
	public Message(String playerID) {
		this.playerID = playerID; 
	}
	
	@Deprecated
	public Message(String playerID, int civilisationID,MessageType type){
		this(playerID);
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
		return getPacketId() == m.getPacketId() && m.playerID.equals(playerID);
		
	}
	
}
