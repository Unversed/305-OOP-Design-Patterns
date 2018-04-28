package component;

import utils.Decorator;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Champion;
import model.Database;

public class Connections extends JPanel {
    private Champion current;
    private JLabel banner;
    private JPanel frame;
    private ArrayList<Champion> connections;
    private ActionListener selected;

    public Champion getCurrent() {
        return current;
    }

    public void setCurrent(Champion current) {
        this.current = current;
    }

    public JLabel getBanner() {
        return banner;
    }

    public void setBanner(JLabel banner) {
        this.banner = banner;
    }

    public JPanel getFrame() {
        return frame;
    }

    public void setFrame(JPanel frame) {
        this.frame = frame;
    }

    public ArrayList<Champion> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Champion> connections) {
        this.connections = connections;
    }

    public ActionListener getSelected() {
        return selected;
    }

    public void setSelected(ActionListener s) {
        this.selected = s;
    }

    public void addSelectedListener(ActionListener s) {
	selected = s;
    }

    public void getList() {
	frame.removeAll();

	for (Iterator<Champion> i = connections.iterator(); i.hasNext();) {
	    Champion current = i.next();
	    Connection panel = new Connection(current, selected);
	    frame.add(panel);
	}

	validate();
	repaint();
    }

    public void refresh() {
	Database data = Database.getInstance();
	connections = data.connections(current);
	getList();
    }

    public Connections(Champion current) {
	this.current = current;
	connections = new ArrayList<>();

	frame = new JPanel();
	frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));

	banner = new JLabel("Connections", JLabel.CENTER);
	banner.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");

	setLayout(new BorderLayout());
	add(banner, BorderLayout.NORTH);
	add(new JScrollPane(frame), BorderLayout.CENTER);
	setBorder(null);
    }
}
