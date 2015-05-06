package com.mobciv.protocol;

public class HeartBeatRequest extends Message implements java.io.Serializable{

	HeartBeatRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HEARTBEAT);
	}
}
