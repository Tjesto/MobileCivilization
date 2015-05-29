package com.mobciv.datamodel;

public class AbstractResponse extends Message {
	
	private final int responseId;

	public AbstractResponse(int responseId, String playerID, int civilisationID,
			MessageType type) {
		super(playerID, civilisationID, type);
		this.responseId = responseId;
	}

	@Override
	public final int getPacketId() {
		return responseId;
	}

}
