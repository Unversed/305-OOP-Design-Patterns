package alexa;

import command.*;
import lightDevice.*;
import phoneDevice.*;
import tvDevice.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import alexa.Alexa.Generic;

/*
 * Assignment 2
 * Smart home device called Alexa.
• Alexa should recognize your voice
• Alexa recognize a series of devices that are connected to it
• These devices are lights,TV, and your phone. 
• Customers should be able to add new devices to Alexa.
• Alexa can recognize 4 different orders
• Turning on the lights
• Customers should be able to add new light to the list of recognized lights
• Turning off the lights
• Playing the music on your phone
• Playing movie on tv streamed from Amazon or Netflix
• Customer should be able to add new source for streaming movie


//TODO:
 * add generic device such that customer can initialize with voice
 * figure out how to: Customer should be able to add new orders 
 * 		and devices to Alexa. (e.g., locking (new order) the front door (new device) )
 * 
 * Highlight the design pattern you are using in your design 
 * 		and map your classes with the element of the used design. Submit this files as PDF.

Submit your UML digram as PDF.

Write your code and add a driver to test the functionality of your software.

For at least two of the functionalities of your system write a unit test.

Submit your pdf and source code as one zip file name as Firstname-LastnameAssign2
















 */

public final class Alexa {
    private static Alexa uniqueInstance; // SINGLETON!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private HashMap<String, Command> commands;
    private List<Light> lights;

    private Alexa() {
	commands = new HashMap<String, Command>();
	lights = new ArrayList<Light>();
    }

    private static Alexa init() {
	final Alexa alexa = new Alexa();

	return alexa;
    }

    public static Alexa getInstance() {
	if (uniqueInstance == null)
	    uniqueInstance = Alexa.init();

	return uniqueInstance;
    }

    public void addCommand(String voiceCommand, Command command) {
	commands.put(voiceCommand, command);
    }

    public String parseCommand(String voiceCommand) {
	if (voiceCommand.startsWith("Alexa"))
	    execute(voiceCommand);
	else {
	    String failure = "Voice command not recognized";
	    System.out.println(failure);
	    return failure;
	}
	return voiceCommand;
    }

    public String execute(String voiceCommand) {
	if (commands.containsKey(voiceCommand))
	    commands.get(voiceCommand).execute();
	else {
	    String failure = "Command Does Not Exist";
	    System.out.println(failure);
	    return failure;
	}

	return voiceCommand;
    }

    public void listCommands() {
	System.out.println("Current commands:\n"
		+ commands.keySet().stream().collect(Collectors.joining("\n")));
    }

    public Light initLight(String location) {
	Light light = new Light(location);

	LightOn lightOn = new LightOn(light);
	LightOff lightOff = new LightOff(light);

	uniqueInstance.addCommand("Alexa, turn on " + location + " light.", lightOn);
	uniqueInstance.addCommand("Alexa, turn off " + location + " light.", lightOff);

	lights.add(light);

	System.out.println(location + " light initialized.");

	return light;
    }

    public Phone initPhone(String owner) {
	Phone phone = new Phone(owner);

	PhoneOn phoneOn = new PhoneOn(phone);
	PhoneOff phoneOff = new PhoneOff(phone);
	PhoneMusic music = new PhoneMusic(phone);

	uniqueInstance.addCommand("Alexa, turn on " + owner + "'s phone.", phoneOn);
	uniqueInstance.addCommand("Alexa, turn off " + owner + "'s phone.", phoneOff);
	uniqueInstance.addCommand("Alexa, play " + owner + "'s music from phone.",
		music);

	System.out.println(owner + "'s phone  initialized.");

	return phone;
    }

    public TV initTV(String location) {
	TV tv = new TV(location);

	TVOn tvOn = new TVOn(tv);
	TVOff tvOff = new TVOff(tv);

	StreamAmazon sA = new StreamAmazon(tv);
	StreamNetflix sN = new StreamNetflix(tv);

	uniqueInstance.addCommand("Alexa, turn on the " + location + " tv.", tvOn);
	uniqueInstance.addCommand("Alexa, turn off the " + location + " tv.", tvOff);
	uniqueInstance.addCommand("Alexa, stream Amazon on the " + location + " tv.",
		sA);
	uniqueInstance.addCommand("Alexa, stream Netflix on the " + location + " tv.",
		sN);

	System.out.println(location + " TV initialized.");

	return tv;
    }

    public Generic initGeneric(String deviceName, String commandEffect) {
	    Command gc = new GenericCommand(new Generic(deviceName, commandEffect));
	    String commandString = "Alexa, " + commandEffect + " " + deviceName + ".";
	    
	    uniqueInstance.addCommand(commandString, gc);
	    System.out.println(deviceName + " initialized.");
	
	return new Generic(deviceName, commandEffect);
    }
    
    public class Generic {
	String deviceName;
	String commandEffect;

	public Generic(String deviceName, String commandEffect) {
	    this.deviceName = deviceName;
	    this.commandEffect = commandEffect;
	}
	
	public void command() {
	    System.out.println(commandEffect + " " + deviceName);
	}

    }
    
    public class GenericCommand implements Command {
	    Generic generic;
	    
		public GenericCommand(Generic generic) {
			this.generic = generic;
		}

		public void execute() {
			generic.command();
		}
	}
}
