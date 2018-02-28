import java.util.ArrayList;

public class Race{
	String racetype = "IND";
	int runNumber = 1;
	
	ArrayList<Racer> racers;
	
	public Race(){
		racers = new ArrayList<Racer>();
	}
	public Race(ArrayList<Racer> racers) {
		this.racers = racers;
	}
	public void setRaceType(String type){
		switch(type) {
		case "IND":
			racetype = type;
//		case "PARIND":
//			racetype = type;
//		case "GRP":
//			racetype = type;
//		case "PARGRP":
//			racetype = type;
			
		}
	}
	public void addRacer(Racer r){
		racers.add(r);
	}
	public Racer getRacer(int num){
		for(int i = 0; i < racers.size(); ++i) {
			if (racers.get(i).getNum() == i){
				return racers.get(i);
			}
		}
		return null;
	}
	
}
