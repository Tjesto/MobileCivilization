package com.mobciv.protocol.requests;

import com.mobciv.datamodel.Message;
import com.mobciv.protocol.objects.ChangesList;

public class EndTurnRequest extends FromGameRequest {

	public static int REQUEST_ID = 0x0006 + Message.REQUEST;
	
	private final ChangesList changesList;
	
	public EndTurnRequest(String playerID, int civilisationID,  ChangesList changesList) {
		super(REQUEST_ID, playerID, civilisationID);
		this.changesList = changesList;
	}

	public ChangesList getChangesList() {
		return changesList;
	}

}
