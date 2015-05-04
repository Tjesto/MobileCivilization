package com.mobciv.handlers;

public enum Command {
	STOP(Boolean.FALSE),
	NONE(null);
	
	private Object value;
	private Command(Object o) {
		value = o;
	}
	
	public Object getValue() {
		return value;
	}
	
}
