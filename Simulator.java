import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Simulator {
	
	 public final static void main(String[] args) {
		 
		 Scanner input = new Scanner(System.in); 
		 String next; 
	     String[] line;
	     DateFormat formatter = new SimpleDateFormat("h:mm:ss:S");
		
		 do {
			 System.out.print("Enter a command (\"stop\") to finish : ");
			 
			 next = input.nextLine();
	         line = next.split(" ");
	         
	         if (line[0].equalsIgnoreCase("load")) {
	             List<String> commandLines = getCommands(line[1]);
	             for (String commandLine : commandLines) {
	                processCommand(commandLine);
	             }
	          }
	         else {
	        	 Date d = new Date();
	        	 next = formatter.format(d) + " " + next;
	        	 processCommand(next);
	         }
		 } while (next.equalsIgnoreCase("exit") == false);
	 }
	 
	 
	 public static void processCommand(String command) {
		 String [] cmd;
		 
		 System.out.println(command);
		 cmd = command.split(" ");
		 if (cmd[1] == "CANCEL") {
			 // remove current run for racer and queue as nest to start.
		 }
		 else if (cmd[1] == "CONN") {
			 // connect a type of sensor to a panel. Types: {EYE, GATE, PAD}.
		 }
		 else if (cmd[1] == "DNF") {
			 // next competitor to finish will not finish.
		 }
		 else if (cmd[1] == "ENDRUN") {
			 // done with run.
		 }
		 else if (cmd[1] == "EVENT") {
			 // create an event of type: {IND | PARIND | GRP | PARGRP}.
		 }
		 else if (cmd[1] == "FINISH") {
			 // shorthand for TRIG 2.
		 }
		 else if (cmd[1] == "NEWRUN") {
			 // create a new run.
		 }
		 else if (cmd[1] == "NUM") {
			 // set num as next competitor to start.
		 }
		 else if (cmd[1] == "POWER") {
			 // turn chronotimer on/off.
		 }
		 else if (cmd[1] == "RESET") {
			 // reset system to initial state.
		 }
		 else if (cmd[1] == "START") {
			 // shorthand for TRIG 1.
		 }
		 else if (cmd[1] == "TIME") {
			 // set the current time
		 }
		 else if (cmd[1] == "TOG") {
			 // toggle state of the channel
		 }
		 else if (cmd[1] == "TRIG") {
			 // trigger channelih
		 }
	 }
	 
	 
	 public static List<String> getCommands(String fileName) {
		   if(fileName == null) return new ArrayList<String>(0);
		   ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		   File file = new File(classLoader.getResource("resources/" + fileName).getFile());
		   if(! (file.exists() && file.canRead())) {
		      System.err.println("Cannot access file! Non-existent or read access restricted");
		      return new ArrayList<String>(0);
		   }

		   List<String> commandLines = new ArrayList<String>(32);
		   Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		   while(scanner.hasNextLine()) {
		      commandLines.add(scanner.nextLine());
		   }

		   scanner.close();

		   return commandLines;
		}
}
