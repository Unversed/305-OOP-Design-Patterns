package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import component.Connection;
import model.Champion;

class ConnectionTest {

	@Test
	void testConnection() {
		Champion test = new Champion(1, "Test", null);
		Connection connectionTest = new Connection(test, null);
		
		assertEquals(connectionTest.getConnected().getTitle(), "Test");
	}
	
	@Test
	void testCurrentChampion() {
		Champion test = new Champion(1, "Test", "src/images/Default.png");
		Connection current = new Connection(test);
		
		assertEquals(current.getConnected().getId(), 1);
		assertEquals(current.getConnected().getTitle(), "Test");
		assertEquals(current.getConnected().getImgURL(), "src/images/Default.png");
	}

}
