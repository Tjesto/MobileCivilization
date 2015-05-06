package com.mobciv.protocol;

public enum MessageType implements java.io.Serializable{
	HEARTBEAT, HANDSHAKE, JOIN_GAME, NEW_GAME, END_TURN, SERVER_RESPONSE, SERVER_HEARTBEAT_RESPONSE
}
