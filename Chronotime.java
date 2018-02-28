import java.util.ArrayList;

public class Chronotime {
	boolean power = false;
	
	Time currentTime;
	Long startTime = currentTime.initialize();
	Long endTime;
	Race r1 = new Race();
	ArrayList<Racer> raceQueue = new ArrayList<Racer>();
	int qLength = 0;
	ArrayList<Racer> currentRacers = new ArrayList<Racer>();
	int cLength = 0;
	
	Channel c1 = new Channel(1);
	Channel c2 = new Channel(2);
	Channel c3 = new Channel(3);
	Channel c4 = new Channel(4);
	
	public void setRace(Race r){
		r1 = r;
	}
	public boolean power(){
		if(power) {
			power = false;
			return power;
		}
		power = true;
		return power;
	}
	public int toggle(){ 
		
	}
	
	public void setRunner(Racer r){//adds runner to racequeue based off racer
		raceQueue.add(r);
		qLength++;
	}
	public void setRunner(int num) {//adds runner to racequeue based off their number
		if(r1.getRacer(num) != null) {
			raceQueue.add(r1.getRacer(num));
			qLength++;
		}
	}
	public boolean clear(int num) {
		Racer temp = r1.getRacer(num);
		if(temp != null) {
			raceQueue.remove(temp);
			qLength--;
			return true;
		}
		return false;
	}
	
	public boolean swap(){
		if(raceQueue.get(qLength-1) != null){
			if(raceQueue.get(qLength-2)!= null) {
				Racer temp1 = raceQueue.get(qLength-1);
				Racer temp2 = raceQueue.get(qLength-2);
				raceQueue.set(qLength-2, temp1);
				raceQueue.set(qLength-1, temp2);
				return true;
			}
		}
		return false;
	}
	
	public void trigger(Channel c) {
		
		Racer r = raceQueue.remove(0);
		qLength--;
		currentRacers.add(r);
		cLength++;
		r.setRunning(true);
	}
	public void start(){
		c1.trigger();
	}
	public void endRun(){
		endTime = currentTime.stop();
		for(int i = 0; i < cLength; ++i) {
			currentRacers.get(i).finished();
			currentRacers.remove(i);
			i--;
		}
	}
	public void cancel(Racer r, boolean raceAgain){
		currentRacers.remove(r);
		cLength--;
		r.setRunning(false);
		if(raceAgain) {
			raceQueue.add(0, r);
			qLength++;
		}
		else {
			r.finished();
		}
	}
	
}
