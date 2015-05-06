package com.mobciv.protocol;

import com.mobiciv.objects.protocol.ChangesList;

public class ServerHeartbeatResponse extends Message {
	private ChangesList changesList;
	
	public ServerHeartbeatResponse(String playerID, int civilisationID,  ChangesList changesList) {
		super(playerID, civilisationID, MessageType.END_TURN);
		this.setChangesList(changesList);
	}

	public ChangesList getChangesList() {
		return changesList;
	}

	public void setChangesList(ChangesList changesList) {
		this.changesList = changesList;
	}
}
