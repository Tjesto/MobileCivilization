package com.mobciv.protocol.handlers;

public final class RequestHandlersFactory {

	public static AbstractRequestHandler create() {
		AbstractRequestHandler handler = new HandshakeRequestHandler();
		//add other handlers
		return handler;
	}

}
