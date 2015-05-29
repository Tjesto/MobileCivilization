package com.mobciv.protocol.handlers;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.NewGameResponse;
import com.mobciv.protocol.requests.NewGameRequest;

public class NewGameRequestHandler extends AbstractRequestHandler {

	public NewGameRequestHandler() {
		super(NewGameRequest.class, NewGameRequest.REQUEST_ID);		
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		NewGameRequest concreteRequest = (NewGameRequest) getRequest(request);
		
		Log.logger().log(getClass().getName(), concreteRequest + " Received");
		return new NewGameResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID());
	}

}
