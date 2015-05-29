package com.mobciv.protocol.handlers;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.JoinGameResponse;
import com.mobciv.protocol.requests.JoinGameRequest;

public class JoinGameRequestHandler extends AbstractRequestHandler {

	public JoinGameRequestHandler() {
		super(JoinGameRequest.class, JoinGameRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		JoinGameRequest concreteRequest = (JoinGameRequest) getRequest(request);
		
		Log.logger().log(getClass().getName(), concreteRequest + " Received");
		
		return new JoinGameResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID());
	}

}
