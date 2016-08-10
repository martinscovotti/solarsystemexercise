//package com.latam.ml.solar;
//
//public class RunSolarSystem {
//	
//	public RunSolarSystem() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//		
//		Galaxy galaxy = new Galaxy(Weather.SEQUIA);
//
//		Planet beta = new Planet(2000, -3);
//		Planet ferengi = new Planet(500, -1);		
//		Planet vulcano = new Planet(1000, 5);
//		
//		galaxy.getPlanetas().add(beta);
//		galaxy.getPlanetas().add(ferengi);
//		galaxy.getPlanetas().add(vulcano);
//		
//		Weather dayW = Weather.SEQUIA;
//		
//		//3600 means 10 years
//		for(int d=0; d<3650000;d++){
////			System.out.println("**************** EN 10 AÑOS **********************");
////			System.out.println("DIA: " + d);	
//			beta.setPosition(beta.getPositionByDay(d));
//			ferengi.setPosition(ferengi.getPositionByDay(d));
//			vulcano.setPosition(vulcano.getPositionByDay(d));
//			
//			if(galaxy.arePlanetsAligned(ferengi.getPosition(), vulcano.getPosition(), beta.getPosition())){
//				if(galaxy.arePlanetsAligned(ferengi.getPosition(), vulcano.getPosition(), new Position(0,0)))
//					dayW= Weather.SEQUIA;
//				else
//					dayW= Weather.COND_OPTIMAS;	
//			}else if(galaxy.isTheSunInTheArea(ferengi.getPosition(), vulcano.getPosition(), beta.getPosition(),new Position(0,0))){			
//				dayW= Weather.LLUVIA;
//				galaxy.addHeavyRain(ferengi.getPosition(), vulcano.getPosition(), beta.getPosition(), d);
//			}else{
//				dayW= Weather.INESTABLE;
//			}
//			
//			if(!galaxy.getWeather().equals(dayW)){
//				if(dayW.equals(Weather.COND_OPTIMAS))
//					galaxy.setpOptimo(galaxy.getpOptimo()+1);
//				if(dayW.equals(Weather.SEQUIA))
//					galaxy.setpSequia(galaxy.getpSequia()+1);
//				if(dayW.equals(Weather.LLUVIA))
//					galaxy.setPlluvia(galaxy.getPlluvia()+1);
//				galaxy.setWeather(dayW);
//			}
//			
//	
//			
////			System.out.println(d);
////			System.out.println("BETA	[" + beta.getPosition().getX()+","+beta.getPosition().getY()+"]");
////			System.out.println("VULCANO [" + vulcano.getPosition().getX()+","+vulcano.getPosition().getY()+"]");
////			System.out.println("FERENGI [" + ferengi.getPosition().getX()+","+ferengi.getPosition().getY()+"]");
//			
//
////			System.out.println("BETA	[" + beta.getPosition().getX()+","+beta.getPosition().getY()+"]");
////			System.out.println("VULCANO [" + vulcano.getPosition().getX()+","+vulcano.getPosition().getY()+"]");
////			System.out.println("FERENGI [" + ferengi.getPosition().getX()+","+ferengi.getPosition().getY()+"]");
////			System.out.println("CLIMA " + dayW);
//			
//		}
//		
//		System.out.println("**************** EN 10 AÑOS **********************");
//		System.out.println("PERIODOS DE SEQUIA: " + galaxy.getpSequia());
//		System.out.println("PERIODOS DE CONDICIONES OPTIMAS: " + galaxy.getpOptimo());
//		System.out.println("PERIODOS DE LLUVIA: " + galaxy.getPlluvia());
////		galaxy.getMaxRainyDay();
////		beta.getMaxRainyDay();
//	}
//
//}
