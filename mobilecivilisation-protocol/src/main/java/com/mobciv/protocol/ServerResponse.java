package com.mobciv.protocol;

public class ServerResponse implements java.io.Serializable{

	private int code;
	
	public int getCode() {
		return code;
	}
	
	ServerResponse(int code){
		this.code = code;
	}


	
}
