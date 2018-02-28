
public class ChronoController {

	static ChronoTimer ct = new ChronoTimer();
	
	public ChronoController() {
		
	}
	
	public void processCommand(String command) {
		String [] cmd;
		 
		 System.out.println(command);
		 cmd = command.split(" ");
		 
		 if (cmd.length < 2) {
			 System.out.println("Controller: Invalid command");
		 }
		 if (cmd[1].equals("CANCEL")) {
			 // remove current run for racer and queue as next to start.
			 if (cmd.length != 3) {
				 System.out.println("Controller: Invalid number of args");
				 return;
			 }
			 ct.cancel();
		 }
		 else if (cmd[1] == "CONN") {
			 // connect a type of sensor to a panel. Types: {EYE, GATE, PAD}.
			 if (cmd.length != 4) {
				 System.out.println("Controller: Invalid number of args");
				 return;
			 }
			 ct.connectChannel(Integer.parseInt(cmd[2]), cmd[3]);
		 }
		 else if (cmd[1].equals("DNF")) {
			 // next competitor to finish will not finish.
			 ct.dnf();
		 }
		 else if (cmd[1].equals("ENDRUN")) {
			 // done with run.
		 }
		 else if (cmd[1].equals("EVENT")) {
			 // create an event of type: {IND | PARIND | GRP | PARGRP}.
		 }
		 else if (cmd[1].equals("FINISH")) {
			 // shorthand for TRIG 2.
			 ct.trigger(2, cmd[0]);
		 }
		 else if (cmd[1].equals("NEWRUN")) {
			 // create a new run.
		 }
		 else if (cmd[1].equals("NUM")) {
			 // set num as next competitor to start.
			 ct.setRunner(Integer.parseInt(cmd[2]));
		 }
		 else if (cmd[1].equals("PRINT")) {
			 // print results
			 ct.print();
		 }
		 else if (cmd[1].equals("POWER")) {
			 // turn chronotimer on/off.
			 ct.power();
		 }
		 else if (cmd[1].equals("RESET")) {
			 // reset system to initial state.
			 ct = new ChronoTimer();
		 }
		 else if (cmd[1].equals("START")) {
			 // shorthand for TRIG 1.
			 ct.trigger(1, cmd[0]);
		 }
		 else if (cmd[1].equals("TIME")) {
			 // set the current time
		 }
		 else if (cmd[1].equals("TOG")) {
			 // toggle state of the channel
			 ct.toggle(Integer.parseInt(cmd[2]));
		 }
		 else if (cmd[1].equals("TRIG")) {
			 // trigger channel
			 ct.trigger(Integer.parseInt(cmd[2]), cmd[0]);
		 }
	}
}
