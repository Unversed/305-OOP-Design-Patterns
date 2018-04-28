package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Authentication;
import model.Champion;
import model.Database;
import utils.ViewType;
import view.MainView;
import view.OptionsView;

public class OptionsControl {
    private MainView root;
    private OptionsView view;

    private Champion current;

    public MainView getRoot() {
	return root;
    }

    public void setRoot(MainView root) {
	this.root = root;
    }

    public OptionsView getView() {
	return view;
    }

    public void setView(OptionsView view) {
	this.view = view;
    }

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public boolean validTitle(Database data, String title) {

	int length = 6;

	if (title.length() < length) {
	    JOptionPane.showMessageDialog(view,
		    "Title Error: A Champion's Title is " + length
			    + " characters or greater!",
		    "Alert", JOptionPane.ERROR_MESSAGE);
	    return false;
	}

	if (!title.equals(current.getTitle()) && data.hasChampion(title)) {
	    JOptionPane.showMessageDialog(view,
		    "Title Error: Active Champion Title", "Alert",
		    JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	return true;
    }

    public boolean validKey(String key, String valid) {

	int length = 12;

	if (key.length() < length) {
	    JOptionPane.showMessageDialog(view,
		    "Secret Error: A Champion's secrets are " + length
			    + " characters or greater!",
		    "Alert", JOptionPane.ERROR_MESSAGE);
	    return false;
	}

	if (!key.equals(valid)) {
	    JOptionPane.showMessageDialog(view,
		    "Secret Error: Key's are mismatch", "Alert",
		    JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	return true;
    }

    class BackListener implements ActionListener {
	public void actionPerformed(ActionEvent b) {
	    root.setView(ViewType.CHAMPION);
	}
    }

    class DeleteListener implements ActionListener {
	public void actionPerformed(ActionEvent d) {
	    Database data = Database.getInstance();
	    data.deleteAll(current);
	    root.setView(ViewType.STRANGER);
	}
    }

    class SaveListener implements ActionListener {
	public void actionPerformed(ActionEvent s) {
	    String title = "";
	    title = view.getTitle();

	    String key = "";
	    key = view.getKey();

	    String valid = "";
	    valid = view.getValidation();

	    String hash = "";

	    Database data = Database.getInstance();

	    if (!validTitle(data, title) || !validKey(key, valid))
		return;

	    try {
		hash = Authentication.hash(key);

		if (data.updateChampion(current, title, hash)) {
		    current.setTitle(title);
		    JOptionPane.showMessageDialog(view, "Settings Active", "",
			    JOptionPane.WARNING_MESSAGE);

		} else {
		    JOptionPane.showMessageDialog(view,
			    "Database Error: Update Failure", "Alert",
			    JOptionPane.ERROR_MESSAGE);
		}

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public OptionsControl(MainView root, Champion current, OptionsView view) {
	this.root = root;
	this.view = view;

	this.current = current;

	this.view.addBackListener(new BackListener());
	this.view.addDeleteListener(new DeleteListener());
	this.view.addSaveListener(new SaveListener());

    }
}