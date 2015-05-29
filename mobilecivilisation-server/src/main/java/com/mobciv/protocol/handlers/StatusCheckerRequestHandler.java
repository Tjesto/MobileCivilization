package com.mobciv.protocol.handlers;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.StatusCheckerResponse;
import com.mobciv.protocol.requests.StatusCheckerRequest;

public class StatusCheckerRequestHandler extends AbstractRequestHandler {

	public StatusCheckerRequestHandler() {
		super(StatusCheckerRequest.class, StatusCheckerRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		StatusCheckerRequest concreteRequest = (StatusCheckerRequest) getRequest(request);
		
		return new StatusCheckerResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID(), false, null);
	}

}
