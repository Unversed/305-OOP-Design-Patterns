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

public class Feed extends JPanel {
    private boolean profile;

    private JPanel feed;
    private JScrollPane scroll;

    private JLabel banner;
    private JLabel text;

    public void populate(Champion current, boolean wall) {
	ArrayList<Message> posts;
	Database data = Database.getInstance();
	
	if (wall && profile)
	    posts = data.getCurrentMessages(current);

	else if (wall && !profile)
	    posts = data.getMessages(current);

	else {
	    text = new JLabel("You must be following " + current.getTitle()
		    + " to see this content");
	    feed.add(text);
	    return;
	}
	
	feed.removeAll();
	feed.setLayout(new GridLayout(posts.size(), 1, 0, 10));

	for (Iterator<Message> i = posts.iterator(); i.hasNext();) {
	    Message post = i.next();
	    Post panel = new Post(post);
	    feed.add(panel);
	}

	scroll.getVerticalScrollBar().setValue(0);
	revalidate();
	repaint();
    }

    public Feed(boolean profile) {
	this.profile = profile;

	feed = new JPanel();
	setLayout(new BorderLayout(0, 0));
	setBorder(BorderFactory.createLineBorder(Color.black));

	banner = new JLabel("Feed");
	banner.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");
	add(banner, BorderLayout.NORTH);

	scroll = new JScrollPane(feed);
	scroll.setBorder(null);
	add(scroll, BorderLayout.CENTER);
    }
}
