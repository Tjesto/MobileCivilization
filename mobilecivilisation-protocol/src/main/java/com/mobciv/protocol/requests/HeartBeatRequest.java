package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;

public class HeartBeatRequest extends Message implements java.io.Serializable{

	HeartBeatRequest(String playerID, int civilisationID){
		super(playerID, civilisationID,MessageType.HEARTBEAT);
	}
}
