package test;

import static org.junit.Assert.*;

import org.junit.Test;

import alexa.Alexa;
import lightDevice.Light;
import phoneDevice.Phone;
import tvDevice.TV;

public class AlexaTest {
    
    @Test
    public void testInitLight() {
	Alexa alexa = Alexa.getInstance();

	Light testLight = alexa.initLight("test");

	String onVoiceCommand = "Alexa, turn on test light.";

	assertEquals(alexa.parseCommand(onVoiceCommand), onVoiceCommand);
	
	String offVoiceCommand = "Alexa, turn off test light.";

	assertEquals(alexa.parseCommand(offVoiceCommand), offVoiceCommand);
	
    }

    @Test
    public void testInitPhone() {
	Alexa alexa = Alexa.getInstance();

	Phone testPhone = alexa.initPhone("test");

	String onVoiceCommand = "Alexa, turn on test's phone.";

	assertEquals(alexa.parseCommand(onVoiceCommand), onVoiceCommand);
	
	String offVoiceCommand = "Alexa, turn off test's phone.";

	assertEquals(alexa.parseCommand(offVoiceCommand), offVoiceCommand);
	
	String musicVoiceCommand = "Alexa, play test's music from phone.";

	assertEquals(alexa.parseCommand(musicVoiceCommand), musicVoiceCommand);
	
    }
    
    @Test
    public void testInitTV() {
	Alexa alexa = Alexa.getInstance();

	TV testTV = alexa.initTV("test");

	String onVoiceCommand = "Alexa, turn on the test tv.";

	assertEquals(alexa.parseCommand(onVoiceCommand), onVoiceCommand);
	
	String offVoiceCommand = "Alexa, turn off the test tv.";

	assertEquals(alexa.parseCommand(offVoiceCommand), offVoiceCommand);
	
	String amazonVoiceCommand = "Alexa, stream Amazon on the test tv.";

	assertEquals(alexa.parseCommand(amazonVoiceCommand), amazonVoiceCommand);
	
	String netflixVoiceCommand = "Alexa, stream Netflix on the test tv.";

	assertEquals(alexa.parseCommand(netflixVoiceCommand), netflixVoiceCommand);
    }

}
