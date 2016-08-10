package com.latam.ml.solar;

public class Position {

	private int x;
	private int y;
	
	public Position(int posx, int posy) {
		x=posx;
		y=posy;
	}

	public String toString(){
		return "["+getX()+","+getY()+"]";
	}
	
	//GETTERS & SETTERS
	
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
