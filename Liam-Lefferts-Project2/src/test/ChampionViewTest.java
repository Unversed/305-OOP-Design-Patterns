package test;

import view.ChampionView;
import model.Champion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ChampionViewTest {

	@Test
	void defaultSearchFieldTest() {
		Champion championTest = new Champion(1, "Champ0", null);
		ChampionView view = new ChampionView(championTest);
		
		assertEquals(view.getSearchText(), "");
	}
	
	@Test
	void defaultPublishTest() {
		Champion current = new Champion(1, "Champ0", null);
		ChampionView view = new ChampionView(current);
		
		assertEquals(view.getPublishText(), "What say you Champion?");
		
	}
}
