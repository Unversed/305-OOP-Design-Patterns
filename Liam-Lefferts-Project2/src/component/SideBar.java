package component;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.Champion;

public class SideBar extends JPanel {
    private Champion current;
    
    private Current currentPanel;
    private Connections connections;

    
    public void addSelectedListener(ActionListener s) {
	connections.addSelectedListener(s);
    }

    public void addUploadListener(ActionListener u) {
	currentPanel.addUploadListener(u);
    }

    public void getConnections() {
	connections.refresh();
    }

    public void getPhoto() {
	currentPanel.refreshPhoto();
    }
    
    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }
    
    public SideBar(Champion current) {
	this.setCurrent(current);
	currentPanel = new Current(current);
	connections = new Connections(current);

	setBorder(BorderFactory.createLineBorder(Color.black));
	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.add(currentPanel);
	this.add(connections);

    }


}