package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import component.Current;
import model.Champion;

class CurrentTest {

	@Test
	void testImage() {
		Champion test = new Champion(1, "Test", "src/images/Default.png");
		Current current = new Current(test);
		
		assertEquals(current.getImage().getIconHeight(), new ImageIcon("src/images/Default.png").getIconHeight());
		assertEquals(current.getImage().getIconWidth(), new ImageIcon("src/images/Default.png").getIconWidth());
	}
	@Test
	void testCurrentChampion() {
		Champion test = new Champion(1, "Test", "src/images/Default.png");
		Current current = new Current(test);
		
		assertEquals(current.getChampion().getId(), 1);
		assertEquals(current.getChampion().getTitle(), "Test");
		assertEquals(current.getChampion().getImgURL(), "src/images/Default.png");
	}
}
