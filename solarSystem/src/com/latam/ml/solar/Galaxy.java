package com.latam.ml.solar;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Galaxy {
	
	private Planet sol;
	private ArrayList<Planet> planetas = new ArrayList<>();
	
	private int plluvia;
	private int pIntensidad;
	private int pSequia;
	private int pOptimo;
	private Weather weather;
	public Map<Integer,Integer> lluvias= new HashMap<Integer,Integer>(); //dia, perimetro
	
	public Galaxy(Weather weather) {
		this.weather=weather;
		this.sol = new Planet(0,0);
		sol.setPosition(new Position(0, 0));
	}

	/**
	 * Verifico si tres puntos estan alineados
	 * Formula:    x2-x1 / x3-x2 = y2-y1 / y3-y2
	 * @param pos1 x1,y1
	 * @param pos2 x2,y2
	 * @return
	 */
	public boolean arePlanetsAligned(Position pos1, Position pos2, Position pos3){
		if(Line2D.ptLineDist(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), pos3.getX(), pos3.getY())==0)
			return true;
		else
			return false;	
			
		
	}
	
	/** 
	 * Verifica si el sol esta en el area
	 * double ABC = Math.abs (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
	 * @param pos1
	 * @param pos2
	 * @return
	 */
	public boolean isTheSunInTheArea(){
		Polygon pol = new Polygon();
		for(Planet p:this.getPlanetas()){
			pol.addPoint(p.getPosition().getX(), p.getPosition().getY());
		}
			
		return pol.contains(getSol().getPosition().getX(), getSol().getPosition().getY());
	}
	
	/**
	 * Agrega a un map el dia y la lluvia de ese dia
	 *      ____________________
		   /       2          2
		 \/ (y2-y1)  + (x2-x1)
	 * @return
	 */
	public void addHeavyRain(int day){
		Position pos1 = getPlanetas().get(0).getPosition();
		Position pos2 = getPlanetas().get(1).getPosition(); 
		Position pos3 = getPlanetas().get(2).getPosition();
		double p12 = Math.sqrt(
	            (pos1.getX() - pos2.getX()) *  (pos1.getX() - pos2.getX()) + 
	            (pos1.getY() - pos2.getY()) *  (pos1.getY() - pos2.getY())
	        );
		
		double p02 = Math.sqrt(
	            (pos3.getX() - pos2.getX()) *  (pos3.getX() - pos2.getX()) + 
	            (pos3.getY() - pos2.getY()) *  (pos3.getY() - pos2.getY())
	        );
		
		double p01 = Math.sqrt(
	            (pos3.getX() - pos1.getX()) *  (pos3.getX() - pos1.getX()) + 
	            (pos3.getY() - pos1.getY()) *  (pos3.getY() - pos1.getY())
	        );
		lluvias.put(new Integer(day), new Integer(new Double(p12+p02+p01).intValue()));
	}
	
	
	/**
	 * Imprime los dias con mayor lluvia recorriendo el mapa de dia y perimetro
	 */
	public void printMaxRainyDay(){
        int maxValueInMap=Collections.max(lluvias.values());  // This will return max value in the Hashmap
        ArrayList<Integer> dias = new ArrayList<>(); 
        System.out.println("max value: " + maxValueInMap);
        for (Entry<Integer, Integer> entry : lluvias.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
            	dias.add(entry.getKey());
                System.out.println("DIA DE MAXIMA LLUVIA: "+entry.getKey());     // Print the key with max value
            }
        }
        System.out.println("dias maxima lluvia: "+ dias.size());
        
		
	}
	
	public void setPositionByDay(int day) {

		for(Planet p:this.getPlanetas()){
			int x,y;
			double anguloRadianes = Math.toRadians(day*p.getTranslation());
			x=new Double(Math.cos(anguloRadianes)*p.getDistance()).intValue();
			y=new Double(Math.sin(anguloRadianes)*p.getDistance()).intValue();
			p.setPosition(new Position(x,y));
		}
		
	}
	
	public boolean arePlanetsAligned() {
		if(Line2D.ptLineDist(getPlanetas().get(0).getPosition().getX(), getPlanetas().get(0).getPosition().getY(), 
							getPlanetas().get(1).getPosition().getX(), getPlanetas().get(1).getPosition().getY(), 
							getPlanetas().get(2).getPosition().getX(), getPlanetas().get(2).getPosition().getY())==0)
			return true;
		else
			return false;	
	}
	
	public boolean arePlanetsAlignedToSun() {
		if(Line2D.ptLineDist(getPlanetas().get(0).getPosition().getX(), getPlanetas().get(0).getPosition().getY(), 
							getPlanetas().get(1).getPosition().getX(), getPlanetas().get(1).getPosition().getY(), 
							getSol().getPosition().getX(), getSol().getPosition().getY())==0)
			return true;
		else
			return false;	
	}
	
	//GETTERS & SETTERS

	public int getPlluvia() {
		return plluvia;
	}

	public void setPlluvia(int plluvia) {
		this.plluvia = plluvia;
	}

	public int getpIntensidad() {
		return pIntensidad;
	}

	public void setpIntensidad(int pIntensidad) {
		this.pIntensidad = pIntensidad;
	}

	public int getpSequia() {
		return pSequia;
	}

	public void setpSequia(int pSequia) {
		this.pSequia = pSequia;
	}

	public int getpOptimo() {
		return pOptimo;
	}

	public void setpOptimo(int pOptimo) {
		this.pOptimo = pOptimo;
	}

	public Map<Integer, Integer> getLluvias() {
		return lluvias;
	}

	public void setLluvias(Map<Integer, Integer> lluvias) {
		this.lluvias = lluvias;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather status) {
		this.weather = status;
	}

	public ArrayList<Planet> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(ArrayList<Planet> planetas) {
		this.planetas = planetas;
	}
	
	public Planet getSol() {
		return sol;
	}

	public void setSol(Planet sol) {
		this.sol = sol;
	}

}
