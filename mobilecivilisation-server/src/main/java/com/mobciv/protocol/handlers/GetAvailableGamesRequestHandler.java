package com.mobciv.protocol.handlers;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.GetAvailableGamesResponse;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;

public class GetAvailableGamesRequestHandler extends AbstractRequestHandler {

	public GetAvailableGamesRequestHandler() {
		super(GetAvailableGamesRequest.class, GetAvailableGamesRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		GetAvailableGamesRequest concreteRequest = (GetAvailableGamesRequest) getRequest(request);
		
		Log.logger().log(getClass().getName(), concreteRequest + " Received");
		
		return new GetAvailableGamesResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID(), null);
	}

}
