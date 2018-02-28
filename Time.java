
public class Time {
	public int millis;
	public int seconds;
	public int minutes;
	public int hours;
	
	public Time (String s) {
		String [] spl = s.split(":");
		hours = Integer.parseInt(spl[0]);
		minutes = Integer.parseInt(spl[1]);
		seconds = Integer.parseInt(spl[2]);
		millis = Integer.parseInt(spl[3]);
	}
	
	public static String difference(Time start, Time end) {
		return (end.hours - start.hours) + ":" + (end.minutes - start.minutes) + ":" + 
				(end.seconds - start.seconds) + ":" + (end.millis - start.millis);
	}
	
}
