package com.latam.ml.solar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RunSolarSystem {
	
	public RunSolarSystem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Galaxy galaxy = new Galaxy(Weather.SEQUIA);

		Planet beta = new Planet(2000, -3);
		Planet ferengi = new Planet(500, -1);		
		Planet vulcano = new Planet(1000, 5);
		
		galaxy.getPlanetas().add(beta);
		galaxy.getPlanetas().add(ferengi);
		galaxy.getPlanetas().add(vulcano);
		
		Weather dayW = Weather.SEQUIA;
		galaxy.setpSequia(1);
		
		Map<Weather, Integer> periodos = new HashMap<>();
		
		//3600 means 10 years
		for(int d=0; d<3650;d++){
			galaxy.setPositionByDay(d);
			
			if(galaxy.arePlanetsAligned()){
				if(galaxy.arePlanetsAlignedToSun())
					dayW= Weather.SEQUIA;
				else
					dayW= Weather.COND_OPTIMAS;	
			}else if(galaxy.isTheSunInTheArea()){			
				dayW= Weather.LLUVIA;
				galaxy.addHeavyRain(d);
			}else{
				dayW= Weather.INESTABLE;
			}
			
			
			if(!galaxy.getWeather().equals(dayW)){
				if(!periodos.containsKey(dayW))
					periodos.put(dayW, 0);
				periodos.put(dayW, periodos.get(dayW)+1);
			}
			
		}
		
		System.out.println("**************** EN 10 AÑOS **********************");
		for(Entry<Weather,Integer> val: periodos.entrySet()){
			System.out.println("PERIODO DE "+val.getKey()+ " : "+val.getValue());
		}
		
		galaxy.printMaxRainyDay();
		
	}

}
