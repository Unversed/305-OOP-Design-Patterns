package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;

import utils.ViewType;
import view.ChallengerView;
import view.ChampionView;
import view.LoginView;
import view.MainView;
import view.OptionsView;
import view.StrangerView;

class MainTest {

    @Test
    void testStateChangeAndRootPaneType() {
	MainView testView = new MainView();

	assertEquals(testView.getView(), ViewType.LOGIN);
	assertThat(testView.getFrame().getContentPane().getComponent(0),
		instanceOf(LoginView.class));

	testView.setView(ViewType.STRANGER);

	assertEquals(testView.getView(), ViewType.STRANGER);
	assertThat(testView.getFrame().getContentPane().getComponent(0),
		instanceOf(StrangerView.class));

	testView.setView(ViewType.OPTIONS);

	assertEquals(testView.getView(), ViewType.OPTIONS);
	assertThat(testView.getFrame().getContentPane().getComponent(0),
		instanceOf(OptionsView.class));

	testView.setView(ViewType.CHAMPION);

	assertEquals(testView.getView(), ViewType.CHAMPION);
	assertThat(testView.getFrame().getContentPane().getComponent(0),
		instanceOf(ChampionView.class));

	testView.setView(ViewType.CHALLENGER);

	assertEquals(testView.getView(), ViewType.CHALLENGER);
	assertThat(testView.getFrame().getContentPane().getComponent(0),
		instanceOf(ChallengerView.class));

    }

}
