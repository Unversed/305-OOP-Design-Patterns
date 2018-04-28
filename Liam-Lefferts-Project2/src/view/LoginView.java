package view;

import utils.Decorator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.LoginControl.*;

public class LoginView extends JPanel {
    private JLabel banner;
    private JLabel titleLabel;
    private JLabel keyLabel;

    private JTextField titleField;
    private JPasswordField keyField;

    private JButton signUp;
    private JButton login;
    private JButton exit;

    public void addExitListener(ExitListener e) {
	exit.addActionListener(e);
    }

    public void addLoginListener(LoginListener l) {
	login.addActionListener(l);
    }

    public void addSignupListener(SignUpListener s) {
	signUp.addActionListener(s);
    }

    public String getKey() {
	return new String(keyField.getPassword());
    }

    public String getTitle() {
	return titleField.getText();
    }

    public LoginView() {
	banner = new JLabel("Code Champions", JLabel.CENTER);
	banner.setBorder(BorderFactory.createLineBorder(Color.black));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 60);
	Decorator.setFontColor(banner, "red");
	banner.setPreferredSize(new Dimension(500, 100));
	
	JPanel bannerFrame = new JPanel();
	bannerFrame.add(banner);

	Box labels = Box.createVerticalBox();
	labels.add(Box.createRigidArea(new Dimension(0, 150)));
	
	titleLabel = new JLabel("Title ");
	titleLabel.setForeground(Color.red);
	labels.add(titleLabel);
	
	labels.add(Box.createRigidArea(new Dimension(0, 10)));
	
	keyLabel = new JLabel("Secret ");
	keyLabel.setForeground(Color.red);
	labels.add(keyLabel);

	Box fields = Box.createVerticalBox();
	fields.add(Box.createRigidArea(new Dimension(0, 150)));
	
	titleField = new JTextField(25);
	fields.add(titleField);
	
	fields.add(Box.createRigidArea(new Dimension(0, 10)));
	
	keyField = new JPasswordField(25);
	fields.add(keyField);

	Box buttons = Box.createVerticalBox();
	buttons.setBackground(Color.white);
	buttons.add(Box.createRigidArea(new Dimension(0, 150)));
	
	login = new JButton("Login");
	login.setBackground(Color.red);
	login.setOpaque(true);
	login.setForeground(Color.white);
	login.setPreferredSize(new Dimension(100, 20));
	
	JPanel loginFrame = new JPanel();
	loginFrame.add(login);
	buttons.add(loginFrame);

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
	frame.setBackground(Color.white);
	frame.setPreferredSize(new Dimension(800, 500));
	frame.add(bannerFrame, BorderLayout.PAGE_START);
	frame.add(flowFrame, BorderLayout.CENTER);
	frame.add(exitFrame, BorderLayout.PAGE_END);
	add(frame);
    }
}
