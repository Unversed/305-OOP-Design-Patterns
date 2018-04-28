package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import component.Connections;
import model.Champion;

class ConnectionsTest {

	@Test
	void testCurrentChampion() {
		Champion test = new Champion(1, "Test", "src/images/Default.png");
		Connections current = new Connections(test);
		
		assertEquals(current.getCurrent().getId(), 1);
		assertEquals(current.getCurrent().getTitle(), "Test");
		assertEquals(current.getCurrent().getImgURL(), "src/images/Default.png");
	}

}
