package com.mobciv.protocol;

public class ServerResponseMessage implements java.io.Serializable{

	private int code;
	
	public int getCode() {
		return code;
	}
	
	ServerResponseMessage(int code){
		this.code = code;
	}


	
}
