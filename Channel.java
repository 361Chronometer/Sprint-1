import java.time.LocalTime;

public class Channel {
	int channelNum;
	Time time; // current time
	boolean enable = false;
	
	Long t = time.initialize(); //holds the value of the start/end returned by initialize or stop
	
	public Channel(int num) {
		channelNum = num;
	}
	
	public void toggle() {
		if (enable) {
			enable = false;
		} else {
			enable = true;
		}
	}
	
	public void trigger() {
		if (enable) t = time.stop();
		
	}
	
	public void connect(String sensor) {
		if (enable) {
			switch(sensor) {
			case "EYE":
				
			case "GATE":
				
			case "PAD":
				
			}
		}
	}
	
	public void disconnect(String sensor) {
		if (enable) {
			switch(sensor) {
			case "EYE":
				
			case "GATE":
				
			case "PAD":
				
			}
		}
	}
}
