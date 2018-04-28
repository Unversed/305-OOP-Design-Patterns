package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import component.Publish;

class PublishTest {

	@Test
	void defaultPublishTest() {
		Publish publishTest = new Publish();
		
		assertEquals(publishTest.getText(), "What say you Champion?");
		
	}

}
