package com.mobciv.datamodel;

public class AbstractRequest extends Message {
	
	private final int requestId;

	public AbstractRequest(int requestId, String playerID) {
		super(playerID);
		this.requestId = requestId;
	}
	
	@Deprecated
	public AbstractRequest(int requestId, String playerID, int civilisationID,
			MessageType type) {
		super(playerID, civilisationID, type);
		this.requestId = requestId;
	}

	@Override
	public final int getPacketId() {
		return requestId;
	}

}
