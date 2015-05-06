package com.mobciv.protocol;

public class HeartBeatMessage extends Message implements java.io.Serializable{

	HeartBeatMessage(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HEARTBEAT);
	}
}
