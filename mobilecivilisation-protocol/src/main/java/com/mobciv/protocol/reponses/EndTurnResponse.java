package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;
import com.mobciv.protocol.objects.ChangesList;

public class EndTurnResponse extends Message {
	
	public static int RESPONSE_ID = 0x0006 + Message.RESPONSE;		

	public EndTurnResponse(String playerID, int civilisationID,  ChangesList changesList) {
		super(RESPONSE_ID, playerID, civilisationID, MessageType.END_TURN);
	}

}
