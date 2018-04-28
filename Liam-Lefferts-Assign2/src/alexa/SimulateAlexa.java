package alexa;

import alexa.Alexa.Generic;
import lightDevice.*;
import phoneDevice.*;
import tvDevice.*;

public class SimulateAlexa {

	public static void main(String[] args) {
	    Alexa alexa = Alexa.getInstance();
	    
	    Light entryLight = alexa.initLight("Entry Way");
	    Phone usersPhone = alexa.initPhone("User");
	    TV MstrBathTV = alexa.initTV("Master Bathroom");
	    
	    alexa.listCommands();
	    
	    Light hallLight = alexa.initLight("Hallway");
	    
	    String Command = "Alexa, turn on Hallway light.";
	    
	    System.out.println( alexa.parseCommand( Command ) );
	    
	    String commandEffect = "lock";
	    String deviceName = "front door";
	    Generic test = alexa.initGeneric(deviceName, commandEffect);
	    
	    String testCommand = "Alexa, " + commandEffect + " " + deviceName + ".";
	    System.out.println( alexa.parseCommand(testCommand ) );
	}

}
