package component;

import utils.Decorator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Publish extends JPanel {
    private JLabel banner;
    private JTextPane textPane;
    private JButton publish;

    public void addPublishListener(ActionListener p) {
	publish.addActionListener(p);
    }

    public String getText() {
	return textPane.getText();
    }

    public Publish() {
	this.setLayout(new BorderLayout(0, 0));
	setBorder(BorderFactory.createLineBorder(Color.black));

	banner = new JLabel("Publish");
	banner.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");

	textPane = new JTextPane();
	textPane.setText("What say you Champion?");

	publish = new JButton("Publish");
	publish.setBackground(Color.red);
	publish.setOpaque(true);
	publish.setForeground(Color.white);

	this.add(banner, BorderLayout.NORTH);
	this.add(textPane, BorderLayout.CENTER);
	this.add(publish, BorderLayout.EAST);
    }
}
