package com.mobciv.protocol.handlers;

public final class RequestHandlersFactory {

	public static AbstractRequestHandler create() {
		AbstractRequestHandler handler = new HandshakeRequestHandler();
		handler.add(new NewGameRequestHandler());
		handler.add(new JoinGameRequestHandler());
		return handler;
	}

}
