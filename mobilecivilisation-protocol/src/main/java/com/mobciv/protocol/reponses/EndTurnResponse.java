package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;
import com.mobciv.protocol.objects.ChangesList;

public class EndTurnResponse extends Message {

	private ChangesList changesList;
	
	public EndTurnResponse(String playerID, int civilisationID,  ChangesList changesList) {
		super(playerID, civilisationID, MessageType.END_TURN);
		this.setChangesList(changesList);
	}

	public void setChangesList(ChangesList changesList) {
		this.changesList = changesList;
	}
}
