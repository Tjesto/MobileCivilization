package com.mobciv.protocol.requests;

import com.mobciv.datamodel.AbstractRequest;
import com.mobciv.datamodel.Message;

public class HandshakeRequest extends AbstractRequest {

	public static int REQUEST_ID = 0x0001 + Message.REQUEST;		

	public HandshakeRequest(String playerID){
		super(REQUEST_ID, playerID);		
	}

}
