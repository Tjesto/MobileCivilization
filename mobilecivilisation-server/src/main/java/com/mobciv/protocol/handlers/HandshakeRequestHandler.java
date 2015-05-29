package com.mobciv.protocol.handlers;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.HandshakeRequest;

public class HandshakeRequestHandler extends AbstractRequestHandler {

	@SuppressWarnings("unchecked")
	public HandshakeRequestHandler() {
		super(HandshakeRequest.class, HandshakeRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		HandshakeRequest concreteRequest = (HandshakeRequest) getRequest(request);
		
		//handleRequest;
		
		Log.logger().log(getClass().getName(), concreteRequest + " Received");
		
		return new HandshakeResponse(concreteRequest.getPlayerID(), concreteRequest.getCivilisationID());
	}

}
