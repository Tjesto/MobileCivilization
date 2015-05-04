package com.mobciv.handlers;

public class StopCommandFilter extends ServerSteeringCommandFilter {
	private static final String STOP = "stop";
	private static final Command RESULT = Command.STOP;

	@Override
	public Command handle(String inputCommand) {
		String handledCommand = inputCommand.toLowerCase().trim().replaceAll("\r\n", "");
		if (STOP.equals(handledCommand)) {
			return RESULT;
		}
		return continueHandling(inputCommand);
	}

}
