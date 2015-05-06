package com.mobiciv.objects.protocol;

public class Coordinates implements java.io.Serializable{
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
