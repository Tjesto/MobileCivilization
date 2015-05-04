package com.mobciv.handlers;

public abstract class ServerSteeringCommandFilter {
	protected ServerSteeringCommandFilter next;
	
	public abstract Command handle(String inputCommand);
	
	public void addNext(ServerSteeringCommandFilter next) {
		this.next = next;
	}
	
	protected Command continueHandling(String inputCommand) {		
		return next != null ? next.handle(inputCommand) : Command.NONE;
	}
}
