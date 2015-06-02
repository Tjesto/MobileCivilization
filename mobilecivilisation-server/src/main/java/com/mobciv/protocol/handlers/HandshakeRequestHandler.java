package com.mobciv.protocol.handlers;

import com.mobciv.Log.Log;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.HandshakeRequest;

public class HandshakeRequestHandler extends AbstractRequestHandler {

	public HandshakeRequestHandler() {
		super(HandshakeRequest.class, HandshakeRequest.REQUEST_ID);
	}

	@Override
	public JsonSerializable handleRequest(String request) {
		
		if (!filterRequest(request)) {
			return pushRequest(request);
		}
		
		HandshakeRequest concreteRequest = (HandshakeRequest) getRequest(request);
		Log.logger().log(getClass().getName(), concreteRequest + " Received");
		
		//handleRequest;
		//wpis do bazy z informacj¹ o graczu				
		//stworzyæ odpowiedni response
		return new HandshakeResponse(concreteRequest.getPlayerID(), -1);
	}

}
