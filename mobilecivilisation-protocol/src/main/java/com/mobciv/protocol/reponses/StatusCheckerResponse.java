package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;
import com.mobciv.protocol.objects.ChangesList;

public class StatusCheckerResponse extends Message {
	
	public static int RESPONSE_ID = 0x0000 + Message.RESPONSE;
	
	private final ChangesList changesList;

	private final boolean changed;
	
	public StatusCheckerResponse(String playerID, int civilisationID, boolean changed, ChangesList changesList) {
		super(RESPONSE_ID, playerID, civilisationID, MessageType.HEARTBEAT);
		this.changed = changed;
		this.changesList = changesList;
	}

	public ChangesList getChangesList() {
		return changesList;
	}

	public boolean hasChanged() {
		return changed;
	}

}
