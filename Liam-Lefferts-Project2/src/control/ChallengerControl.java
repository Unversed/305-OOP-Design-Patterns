package control;

import utils.ViewType;
import view.ChallengerView;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Champion;
import model.Database;

public class ChallengerControl {
    private MainView root;
    private ChallengerView view;

    private Champion current;
    private Champion selected;

    public MainView getRoot() {
	return root;
    }

    public void setRoot(MainView root) {
	this.root = root;
    }

    public ChallengerView getView() {
	return view;
    }

    public void setView(ChallengerView view) {
	this.view = view;
    }

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public Champion getSelected() {
	return selected;
    }

    public void setSelected(Champion selected) {
	this.selected = selected;
    }

    class BackListener implements ActionListener {
	public void actionPerformed(ActionEvent b) {
	    current = null;
	    root.setView(ViewType.CHAMPION);
	}
    }

    class FollowListener implements ActionListener {
	public void actionPerformed(ActionEvent f) {
	    Database data = Database.getInstance();
	    JButton follow = (JButton) f.getSource();

	    if (follow.getText().equals("Unfollow")) {
		data.unconnect(selected, current);
		follow.setText("Follow");
		view.setFollowing(false);
	    } else {
		data.connect(selected, current);
		follow.setText("Unfollow");
		view.setFollowing(true);
	    }

	    view.refresh();
	}
    }

    public ChallengerControl(MainView root, ChallengerView view,
	    Champion selected, Champion current) {
	this.root = root;
	this.view = view;

	this.current = current;
	this.selected = selected;

	this.view.addBackListener(new BackListener());
	this.view.addFollowListener(new FollowListener());
	this.view.refresh();

    }
}
