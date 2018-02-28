import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Time {
	public static long millis = System.currentTimeMillis() % 1000;
	public static long start;
	public static long end;
	DateFormat formatter = new SimpleDateFormat("h:mm:ss:S");
	
	// initialize method
	public long initialize () {
		start = millis;
		return start;
	}
	
	// stop method
	public long stop () {
		end = millis;
		return end;
	}
	
	// current time getter
	public static long getTime() {
		return millis;
	}
	
	// start getter
	public static long getStart() {
		return start;
	}
	
	// end getter
	public static long getEnd() {
		return end;
	}
	
	// format the race time to return
	public String form () {
		long race = end - start;
		Date r = new Date (race);
		return formatter.format(r);
		
	}
}
