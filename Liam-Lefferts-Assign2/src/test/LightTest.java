package test;

import static org.junit.Assert.*;

import org.junit.Test;

import alexa.Alexa;
import lightDevice.Light;
import lightDevice.LightOn;

public class LightTest {

    @Test
    public void testLight() {
	Alexa alexa = Alexa.getInstance();

	Light testLight = new Light("test");
	LightOn testLightCommand = new LightOn(testLight);

	String voiceCommand = "Alexa, turn on test light.";

	alexa.addCommand(voiceCommand, testLightCommand);

	assertEquals(alexa.parseCommand(voiceCommand), voiceCommand);
    }

    @Test
    public void testIsOn() {
	Light testLight = new Light("test");

	assertEquals(testLight.isOn(), false);
    }

    @Test
    public void testOn() {
	Light testLight = new Light("test");

	assertEquals(testLight.isOn(), false);
	testLight.on();
	assertEquals(testLight.isOn(), true);
    }

    @Test
    public void testOff() {
	Light testLight = new Light("test");
	testLight.on();

	assertEquals(testLight.isOn(), true);
	testLight.off();
	assertEquals(testLight.isOn(), false);
    }

    @Test
    public void testSetOn() {
	Light testLight = new Light("test");
	assertEquals(testLight.isOn(), false);

	testLight.setOn(true);
	assertEquals(testLight.isOn(), true);
	
	testLight.setOn(false);
	assertEquals(testLight.isOn(), false);
    }

}
