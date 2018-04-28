package view;

import utils.Decorator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StrangerView extends JPanel {
    private JLabel banner;
    private JLabel titleLabel;
    private JLabel keyLabel;
    private JLabel validationLabel;

    private JTextField titleField;
    private JPasswordField keyField;
    private JPasswordField validationField;

    private JButton exit;
    private JButton back;
    private JButton signUp;

    public void addBackListener(ActionListener b) {
	back.addActionListener(b);
    }

    public void addExitListener(ActionListener e) {
	exit.addActionListener(e);
    }

    public void addSignupListener(ActionListener s) {
	signUp.addActionListener(s);
    }

    public String getKey() {
	return new String(keyField.getPassword());
    }

    public String getTitle() {
	return titleField.getText();
    }

    public String getValidation() {
	return new String(validationField.getPassword());
    }

    public StrangerView() {
	banner = new JLabel("Hail Stranger", JLabel.CENTER);
	banner.setBorder(BorderFactory.createLineBorder(Color.black));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 60);
	Decorator.setFontColor(banner, "red");
	banner.setPreferredSize(new Dimension(500, 100));

	JPanel bannerFrame = new JPanel();
	bannerFrame.add(banner);

	Box labels = Box.createVerticalBox();
	labels.add(Box.createRigidArea(new Dimension(0, 150)));

	titleLabel = new JLabel("Champion Title ");
	titleLabel.setForeground(Color.red);
	labels.add(titleLabel);

	labels.add(Box.createRigidArea(new Dimension(0, 10)));

	keyLabel = new JLabel("Secret Key");
	keyLabel.setForeground(Color.red);
	labels.add(keyLabel);

	labels.add(Box.createRigidArea(new Dimension(0, 10)));

	validationLabel = new JLabel("Validate Key");
	validationLabel.setForeground(Color.red);
	labels.add(validationLabel);

	Box fields = Box.createVerticalBox();
	fields.add(Box.createRigidArea(new Dimension(0, 150)));

	titleField = new JTextField(25);
	fields.add(titleField);

	fields.add(Box.createRigidArea(new Dimension(0, 10)));

	keyField = new JPasswordField(25);
	fields.add(keyField);

	fields.add(Box.createRigidArea(new Dimension(0, 10)));

	validationField = new JPasswordField(25);
	fields.add(validationField);

	Box buttons = Box.createVerticalBox();
	buttons.add(Box.createRigidArea(new Dimension(0, 150)));

	back = new JButton("Back");
	back.setBackground(Color.red);
	back.setOpaque(true);
	back.setForeground(Color.white);
	back.setPreferredSize(new Dimension(100, 20));

	JPanel backFrame = new JPanel();
	backFrame.add(back);
	buttons.add(backFrame);

	signUp = new JButton("Signup");
	signUp.setBackground(Color.red);
	signUp.setOpaque(true);
	signUp.setForeground(Color.white);
	signUp.setPreferredSize(new Dimension(100, 20));

	JPanel signUpFrame = new JPanel();
	signUpFrame.add(signUp);
	buttons.add(signUpFrame);

	JPanel flowFrame = new JPanel(new FlowLayout());
	flowFrame.add(labels);
	flowFrame.add(fields);
	flowFrame.add(buttons);
	flowFrame.setBorder(BorderFactory.createLineBorder(Color.black));
	flowFrame.setBackground(Color.white);

	exit = new JButton("Exit");
	exit.setBackground(Color.red);
	exit.setOpaque(true);
	exit.setForeground(Color.white);
	exit.setPreferredSize(new Dimension(200, 40));

	JPanel exitFrame = new JPanel();
	exitFrame.add(exit);

	JPanel frame = new JPanel(new BorderLayout());
	frame.setPreferredSize(new Dimension(1000, 500));
	frame.add(bannerFrame, BorderLayout.PAGE_START);
	frame.add(flowFrame, BorderLayout.CENTER);
	frame.add(exitFrame, BorderLayout.PAGE_END);
	add(frame);
    }
}
