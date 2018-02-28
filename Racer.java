
public class Racer {
	Time startTime;
	Time endTime;//DNF time class
	
	int num;
	String name;
	
	boolean isRunning = false;
	boolean completed = false;//DNF time class
	
	public Racer(int n) {
		this.num = n;
	}
	public void setNum(int n) {
		num = n;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getNum(){
		return num;
	}
	public void setRunning(boolean s){
		isRunning = s;
	}
	public void finished(String s){
			endTime = new Time(s);
			completed = true;
	}
	public boolean getFinished(){
		return completed;
	}
	public void setStart(String s) {
		startTime = new Time(s);
	}
	public String finishTime() {
		return Time.difference(startTime, endTime);
	}
	
}
