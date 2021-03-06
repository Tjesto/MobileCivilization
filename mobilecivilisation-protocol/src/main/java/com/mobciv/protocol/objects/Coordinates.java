package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class Coordinates implements JsonSerializable {
	private int x;
	private int y;
	
	Coordinates(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
