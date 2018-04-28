package view;

import model.Champion;
import utils.ViewType;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ChallengerControl;
import control.ChampionControl;
import control.LoginControl;
import control.OptionsControl;
import control.StrangerControl;

public class MainView {

    private static Champion current;
    private static Champion selected;

    private JFrame frame;
    private JPanel root;

    private LoginView login;
    private StrangerView stranger;
    private OptionsView options;
    private ChampionView champion;
    private ChallengerView challenger;

    private LoginControl loginControl;
    private StrangerControl strangerControl;
    private OptionsControl optionsController;
    private ChampionControl championController;
    private ChallengerControl challengerController;

    private ViewType view;

    public void setView(ViewType newView) {
	view = newView;
	init();
    }

    public ViewType getView() {
	return view;
    }

    public JFrame getFrame() {
	return frame;
    }

    // initialize frame contents
    private void init() {

	frame.getContentPane().removeAll();

	switch (view) {

	case LOGIN:
	    current = new Champion();
	    login = new LoginView();
	    loginControl = new LoginControl(this, current, login);
	    root = login;
	    break;

	case STRANGER:
	    current = new Champion();
	    stranger = new StrangerView();
	    strangerControl = new StrangerControl(this, current, stranger);
	    root = stranger;
	    break;

	case OPTIONS:
	    options = new OptionsView(current);
	    optionsController = new OptionsControl(this, current, options);
	    root = options;
	    break;

	case CHAMPION:
	    selected = new Champion();
	    champion = new ChampionView(current);
	    championController = new ChampionControl(this, champion, current,
		    selected);
	    root = champion;
	    break;

	case CHALLENGER:
	    challenger = new ChallengerView(current, selected);
	    challengerController = new ChallengerControl(this, challenger,
		    current, selected);
	    root = challenger;
	    break;

	case EXIT:
	    System.out.println("Exit");
	    System.exit(0);

	default:
	    System.err.println("Application Error: State Unknown");
	    System.exit(-1);
	}

	frame.getContentPane().add(root);
	frame.revalidate();
	frame.repaint();
    }

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainView window = new MainView();
		    window.frame.setVisible(true);
		    window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public MainView() {
	view = ViewType.LOGIN;

	frame = new JFrame();
	frame.setResizable(false);
	frame.setSize(1200, 800);
	

	root = new JPanel();

	init();
    }
}
