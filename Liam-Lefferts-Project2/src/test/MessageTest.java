package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Champion;
import model.Message;

class MessageTest {

	@Test
	void testCreatePost() {
		Champion championTest = new Champion();
		Message message = new Message(championTest.getTitle(), "Test Message");
		
		assertEquals(message.getChampion(), "Default");
		assertEquals(message.getText(), "Test Message");
	}

}
