package com.mobciv.protocol.handlers;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.NewGameResponse;
import com.mobciv.protocol.requests.NewGameRequest;

public class NewGameRequestHandler extends AbstractRequestHandler {

	public NewGameRequestHandler(Class<?> handledRequest, int requestId) {
		super(NewGameRequest.class, NewGameRequest.REQUEST_ID);		
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		NewGameRequest concreteRequest = (NewGameRequest) getRequest(request);
		return new NewGameResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID());
	}

}
