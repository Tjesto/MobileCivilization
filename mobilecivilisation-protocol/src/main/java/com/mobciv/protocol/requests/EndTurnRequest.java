package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;
import com.mobciv.protocol.objects.ChangesList;

public class EndTurnRequest extends Message {

	private ChangesList changesList;
	
	public EndTurnRequest(String playerID, int civilisationID,  ChangesList changesList) {
		super(playerID, civilisationID, MessageType.END_TURN);
		this.setChangesList(changesList);
	}

	public void setChangesList(ChangesList changesList) {
		this.changesList = changesList;
	}
}
