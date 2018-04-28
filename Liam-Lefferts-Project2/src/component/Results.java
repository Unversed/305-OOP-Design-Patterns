package component;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Champion;
import model.Database;

public class Results extends JPanel {
    private JPanel results;
    private JLabel message;
    private ArrayList<Champion> result;
    private ActionListener selectListener;

    public void addSelectListener(ActionListener s) {
	selectListener = s;
    }

    public void populate() {
	results.removeAll();

	for (Iterator<Champion> i = result.iterator(); i.hasNext();) {
	    Champion user = i.next();
	    Connection panel = new Connection(user, selectListener);
	    results.add(panel);
	}

	validate();
	repaint();
    }

    public void refresh(String search) {
	Database data = Database.getInstance();
	result = data.search(search);

	if (result.isEmpty()) {
	    message = new JLabel("No Champions Found");
	    results.add(message, BorderLayout.NORTH);
	}

	populate();
    }

    public Results() {
	setLayout(new BorderLayout());

	results = new JPanel();
	results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));

	result = new ArrayList<>();

	add(new JScrollPane(results), BorderLayout.CENTER);
    }
}
