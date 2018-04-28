package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Champion;
import model.Database;
import utils.ViewType;
import view.LoginView;
import view.MainView;

public class LoginControl {
    private MainView root;
    private LoginView view;

    private Champion current;

    public MainView getRoot() {
	return root;
    }

    public void setRoot(MainView root) {
	this.root = root;
    }

    public LoginView getView() {
	return view;
    }

    public void setView(LoginView view) {
	this.view = view;
    }

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public class ExitListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    root.setView(ViewType.EXIT);
	}
    }

    public class LoginListener implements ActionListener {
	public void actionPerformed(ActionEvent l) {
	    String title = "";
	    title = view.getTitle();

	    String key = "";
	    key = view.getKey();

	    Database data = Database.getInstance();

	    if (data.authChampion(current, title, key)) {
		root.setView(ViewType.CHAMPION);
	    } else {
		JOptionPane.showMessageDialog(view,
			"Authentication Error: Champion Unknown", "Alert",
			JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    public class SignUpListener implements ActionListener {
	public void actionPerformed(ActionEvent s) {
	    root.setView(ViewType.STRANGER);
	}
    }

    public LoginControl(MainView root, Champion current, LoginView view) {
	this.root = root;
	this.view = view;

	this.current = current;

	this.view.addExitListener(new ExitListener());
	this.view.addLoginListener(new LoginListener());
	this.view.addSignupListener(new SignUpListener());
    }
}