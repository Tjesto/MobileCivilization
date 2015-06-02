package com.mobciv.protocol.requests;

import com.mobciv.datamodel.AbstractRequest;

public abstract class FromGameRequest extends AbstractRequest {		

	private final int civilisationId;

	public FromGameRequest(int requestId, String playerID, int civilisationId) {
		super(requestId, playerID);
		this.civilisationId = civilisationId;
	}
	
	public int getCivilisationId() {
		return civilisationId;
	}

}
