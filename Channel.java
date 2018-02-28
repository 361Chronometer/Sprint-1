import java.time.LocalTime;

public class Channel {
	int channelNum;
	LocalTime time;
	boolean enable = false;
	
	LocalTime t = LocalTime.now();
	
	public Channel(int num) {
		channelNum = num;
	}
	
	public void toggle() {
		enable = !enable;
	}
	
	public void trigger() {
		if (enable) time = t;
		
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
