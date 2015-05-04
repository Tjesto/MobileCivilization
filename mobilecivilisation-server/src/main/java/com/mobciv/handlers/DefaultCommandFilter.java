package com.mobciv.handlers;

public final class DefaultCommandFilter extends ServerSteeringCommandFilter {

	@Override
	public Command handle(String inputCommand) {
		return continueHandling(inputCommand);
	}

}
