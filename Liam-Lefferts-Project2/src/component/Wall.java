package component;

import utils.Decorator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Champion;
import model.Database;
import model.Message;

public class Wall extends JPanel {
    private JPanel wall;
    private JScrollPane scroll;

    private JLabel banner;

    public void populate(Champion current) {
	ArrayList<Message> messages;
	Database data = Database.getInstance();
	messages = data.getCurrentMessages(current);
	
	wall.removeAll();
	wall.setLayout(new GridLayout(messages.size(), 1, 0, 10));

	for (Iterator<Message> i = messages.iterator(); i.hasNext();) {
	    Message message = i.next();
	    Post text = new Post(message);
	    wall.add(text);
	}

	scroll.getVerticalScrollBar().setValue(0);
	revalidate();
	repaint();
    }

    public Wall() {
	wall = new JPanel();
	setLayout(new BorderLayout(0, 0));
	setBorder(BorderFactory.createLineBorder(Color.black));

	banner = new JLabel("Wall");
	banner.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");
	add(banner, BorderLayout.NORTH);

	scroll = new JScrollPane(wall);
	scroll.setBorder(null);
	add(scroll, BorderLayout.CENTER);
    }
}
