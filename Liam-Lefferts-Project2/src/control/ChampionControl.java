package control;

import model.Champion;
import model.Database;
import utils.ViewType;
import view.ChampionView;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import component.Connection;

public class ChampionControl {
    private MainView root;
    private ChampionView view;

    private Champion current;
    private Champion selected;

    public MainView getMaster() {
	return root;
    }

    public void setMaster(MainView master) {
	this.root = master;
    }

    public ChampionView getView() {
	return view;
    }

    public void setView(ChampionView view) {
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

    public class OptionsListener implements ActionListener {
	public void actionPerformed(ActionEvent o) {
	    root.setView(ViewType.OPTIONS);
	}
    }

    class FileListener implements ActionListener {
	JFileChooser file = new JFileChooser();
	FileNameExtensionFilter extFilter = new FileNameExtensionFilter(
		"JPG/PNG Images", "jpg", "jpeg", "png");
	Database data;

	public void actionPerformed(ActionEvent p) {
	    file.setFileFilter(extFilter);
	    data = Database.getInstance();

	    int value = file.showOpenDialog(view);

	    if (value == JFileChooser.APPROVE_OPTION) {
		try {
		    File source = file.getSelectedFile();
		    current.setImgURL(source.getPath());
		    view.getSideBar().getPhoto();
		    data.updateImage(current);
		} catch (Exception e) {
		    e.printStackTrace();
		}

	    } else {
		System.out.println("Photo Operation Cancelled");
	    }
	}
    }

    public class logOutListener implements ActionListener {
	public void actionPerformed(ActionEvent l) {
	    current = null;
	    JOptionPane.showMessageDialog(view, "Good Bye!",
		    "Champion Logged Out", JOptionPane.WARNING_MESSAGE);

	    root.setView(ViewType.LOGIN);
	}
    }

    class PostListener implements ActionListener {
	public void actionPerformed(ActionEvent p) {
	    String publish = view.getPublishText();

	    if (publish.length() == 0) {
		return;
	    }

	    Database data = Database.getInstance();

	    if (data.addMessage(current, publish)) {
		JOptionPane.showMessageDialog(view, "Message Sent",
			"Message Confirmed Champion",
			JOptionPane.WARNING_MESSAGE);
		System.out.println("New Message");
		view.refresh();
		view.republish();
		view.addPublishListener(new PostListener());
	    }
	}
    }

    public class SearchListener implements ActionListener {
	public void actionPerformed(ActionEvent s) {
	    String phrase = view.getSearchText();
	    view.getResults().refresh(phrase);
	    view.getResults().setVisible(true);
	}
    }

    public class SelectedListener implements ActionListener {
	public void actionPerformed(ActionEvent s) {
	    Connection connection = (Connection) s.getSource();
	    Champion current = connection.getConnected();

	    selected.setAll(current.getId(), current.getTitle(),
		    current.getImgURL());

	    root.setView(ViewType.CHALLENGER);
	}
    }

    public ChampionControl(MainView root, ChampionView view, Champion current,
	    Champion selected) {
	this.root = root;
	this.view = view;

	this.current = current;
	this.selected = selected;

	this.view.addSearchListener(new SearchListener());
	this.view.addSettingsListener(new OptionsListener());
	this.view.addLogOutListener(new logOutListener());
	this.view.addPublishListener(new PostListener());

	this.view.getSideBar().addUploadListener(new FileListener());
	this.view.getSideBar().addSelectedListener(new SelectedListener());
	this.view.getResults().addSelectListener(new SelectedListener());
	this.view.refresh();
	this.view.getSideBar().getConnections();
    }
}
