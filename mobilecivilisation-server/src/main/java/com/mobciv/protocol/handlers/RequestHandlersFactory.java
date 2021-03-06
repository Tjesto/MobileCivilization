package com.mobciv.protocol.handlers;

public final class RequestHandlersFactory {

	public static AbstractRequestHandler create() {
		AbstractRequestHandler handler = new HandshakeRequestHandler();
		handler.add(new NewGameRequestHandler());
		handler.add(new JoinGameRequestHandler());
		handler.add(new StatusCheckerRequestHandler());
		handler.add(new GetAvailableGamesRequestHandler());
		handler.add(new EndTurnRequestHandler());
		return handler;
	}

}
