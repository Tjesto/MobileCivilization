package com.mobciv.protocol.reponses;

import com.mobciv.datamodel.Message;
import com.mobciv.datamodel.MessageType;
import com.mobciv.protocol.objects.AvailableGameList;

public class GetAvailableGamesResponse extends Message {
	
	public static int RESPONSE_ID = 0x0004 + Message.RESPONSE;
	private final AvailableGameList games;

	public GetAvailableGamesResponse(String playerID,
			int civilisationID, AvailableGameList games) {
		super(RESPONSE_ID, playerID, civilisationID, MessageType.SERVER_RESPONSE);
		this.games = games;
	}

	public AvailableGameList getGames() {
		return games;
	}

}
