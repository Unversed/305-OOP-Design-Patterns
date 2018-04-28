package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Champion;

class ChampionTest {

	@Test
	void defaultChampionTest() {
		Champion championTest = new Champion();
		
		assertEquals(championTest.getId(), -1);
		assertEquals(championTest.getTitle(), "Default");
		assertEquals(championTest.getImgURL(), "src/images/Default.png");
	}
	
	@Test
	void championTest() {
		Champion championTest = new Champion(100, "championTest", "src/images/Default.png");
		
		assertEquals(championTest.getId(), 100);
		assertEquals(championTest.getTitle(), "championTest");
		assertEquals(championTest.getImgURL(), "src/images/Default.png");
	}
	
	@Test
	void testProfileImage() {
		Champion championTest = new Champion();
		
		assertEquals(championTest.getImgURL(), "src/images/Default.png");
		championTest.setImgURL(null);
		assertEquals(championTest.getImgURL(), "src/images/Default.png");
	}

}
