package com.latam.ml.solar;

public class Planet {

	private int distance;
	private Position position;
	private double translation;
	private String name;
	
	public Planet(int dis, double trans, Position pos) {
		this.distance=dis;
		this.translation=trans;
		this.position=pos;
	}

	public Planet(int dis, double trans) {
		this.distance=dis;
		this.translation=trans;
	}
	
	public Planet(String name,int dis, double trans) {
		this.setName(name);
		this.distance=dis;
		this.translation=trans;
	}

	/**
	 * Obtiene la posicion de acuerdo al parametro del dia
	 * @param day
	 * @return
	 */
	public Position getPositionByDay(int day) {
		int x,y;
		
		double anguloRadianes = Math.toRadians(day*getTranslation());
		
		x=new Double(Math.cos(anguloRadianes)*getDistance()).intValue();
		
		y=new Double(Math.sin(anguloRadianes)*getDistance()).intValue();
		
		return new Position(x,y);
	}
	
	
	//GETTERS & SETTERS
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getTranslation() {
		return translation;
	}

	public void setTranslation(double translation) {
		this.translation = translation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
