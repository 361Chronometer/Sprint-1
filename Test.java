import java.util.concurrent.TimeUnit;

public class Test {

	public static void main (String args[]) {
		Channel c1 = new Channel(1);
		Channel c2 = new Channel(2);
		
		if (c1.enable == true) System.out.println(c1.channelNum);
		c1.toggle();
		if (c1.enable == true) System.out.println(c2.channelNum);
		c2.toggle();
		if (c2.enable == true) System.out.println(c1.channelNum);
		c1.trigger();
		System.out.println(c1.time);
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c2.trigger();
		System.out.println(c2.time);
	}
}
