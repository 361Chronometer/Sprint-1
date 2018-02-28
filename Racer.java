
public class Racer {
	Time startTime;
	Time endTime;//DNF time class
	
	int num;
	String name;
	
	boolean isRunning = false;
	boolean completed = false;//DNF time class
	
	public void setNum(int n) {
		num = n;
	}
	public void setName(String name){
		this.name = name;
	}
	public void trigger(Channel c){
		
	}
	public int getNum(){
		return num;
	}
	public void setRunning(boolean s){
		isRunning = s;
	}
	public void finished(Time t){
			endTime = t;
			completed = true;
	}
	public void finished() {
		completed = false;
		endTime = null;
	}
	public boolean getFinished(){
		return completed;
	}
//	public setStart(Time t) {
//		startTime = t;
//	}
//	public setEnd(Time t) {
//		endTime = t;
//	}
}
