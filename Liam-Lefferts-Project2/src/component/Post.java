package component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Message;
import utils.Decorator;

public class Post extends JPanel {
	private JLabel champion;
	private JTextArea text;

	public JLabel getChampion() {
	    return champion;
	}

	public void setChampion(JLabel champion) {
	    this.champion = champion;
	}

	public JTextArea getText() {
	    return text;
	}

	public void setText(JTextArea text) {
	    this.text = text;
	}

	public Post(Message message) {
		champion = new JLabel(message.getChampion());
		champion.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

		text = new JTextArea();
		text.setText(message.getText());
		text.setEditable(false);

		Decorator.setFontBold(champion);
		Decorator.setFontSize(text, 12);
		
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.white);
		this.add(champion, BorderLayout.NORTH);
		this.add(text, BorderLayout.CENTER);
	}

}
