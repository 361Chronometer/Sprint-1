import java.util.ArrayList;

public class ChronoTimer {
	boolean power = false;
	
	Time endTime;
	Race r1 = new Race();
	ArrayList<Racer> queued = new ArrayList<Racer>();
	ArrayList<Racer> running = new ArrayList<Racer>();
	ArrayList<Racer> finished = new ArrayList<Racer>();
	
	
	Channel c1 = new Channel(1);
	Channel c2 = new Channel(2);
	
	
	
	public ChronoTimer() {
		
	}
	
	public void consolePrint(String s){
		System.out.println("console: " + s);
	}
	
	public boolean power(){
		power = !power;
		if (power) consolePrint("System is on");
		else consolePrint("System is off");
		return power;
	}
	
	public void connectChannel(int n, String s) {
		if (n == 1) c1.connect(s);
		else if (n == 2) c2.connect(s);
		
		consolePrint("Channel " + n + "has been connected to " + s);
	}
	
	public void toggle(int n){
		if (n == 1) c1.toggle();
		else if (n == 2) c2.toggle();
	}
	
	public void setRunner(int num) {//adds runner to racequeue based off their number
		if(r1.getRacer(num) != null) {
			queued.add(r1.getRacer(num));
		}
		else {
			Racer r = new Racer(num);
			r1.addRacer(r);
			queued.add(r);
		}
	}
	
	public boolean clear(int num) {
		Racer temp = r1.getRacer(num);
		if(temp != null) {
			queued.remove(temp);
			return true;
		}
		return false;
	}
	
	
	public void trigger(int c, String s) {
		if (c == 1) {
			if (!queued.isEmpty()) {
				Racer r = queued.remove(0);
				running.add(r);
				r.setStart(s);
			}
		}
		else {
			if (!running.isEmpty()) {
				Racer r = running.remove(0);
				finished.add(r);
				r.finished(s);
			}
		}
		
	}
	
	public void cancel(){
		queued.add(0, running.remove(0));
	}

	public void print() {
		System.out.println("-----Final Results-----");
		for (Racer r : finished) {
			System.out.println("Racer " + r.num + " " + r.finishTime());
		}
		
	}

	public void dnf() {
		finished.add(running.remove(0));
		
	}
	
}
