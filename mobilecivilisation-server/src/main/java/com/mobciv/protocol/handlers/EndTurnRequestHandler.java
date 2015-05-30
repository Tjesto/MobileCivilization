package com.mobciv.protocol.handlers;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.EndTurnResponse;
import com.mobciv.protocol.reponses.GetAvailableGamesResponse;
import com.mobciv.protocol.requests.EndTurnRequest;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;

public class EndTurnRequestHandler extends AbstractRequestHandler {

	public EndTurnRequestHandler() {
		super(EndTurnRequest.class, EndTurnRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		EndTurnRequest concreteRequest = (EndTurnRequest) getRequest(request);
		
		return new EndTurnResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID(), null);
	}

}
