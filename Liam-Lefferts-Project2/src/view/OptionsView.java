package view;

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

import model.Champion;
import utils.Decorator;

public class OptionsView extends JPanel {
    private Champion current;

    private JLabel banner;
    private JLabel titleLabel;
    private JLabel keyLabel;
    private JLabel validationLabel;

    private JTextField titleField;
    private JPasswordField keyField;
    private JPasswordField validationField;

    private JButton back;
    private JButton delete;
    private JButton save;

    public void addBackListener(ActionListener a) {
	back.addActionListener(a);
    }

    public void addDeleteListener(ActionListener a) {
	delete.addActionListener(a);
    }

    public void addSaveListener(ActionListener a) {
	save.addActionListener(a);
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

    public OptionsView(Champion current) {
	this.current = current;

	banner = new JLabel("Champion Settings", JLabel.CENTER);
	banner.setBorder(BorderFactory.createLineBorder(Color.black));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 46);
	Decorator.setFontColor(banner, "red");
	banner.setPreferredSize(new Dimension(500, 100));

	JPanel bannerFrame = new JPanel();
	bannerFrame.add(banner);

	Box labels = Box.createVerticalBox();
	labels.add(Box.createRigidArea(new Dimension(0, 150)));

	titleLabel = new JLabel("Change Title ");
	titleLabel.setForeground(Color.red);
	labels.add(titleLabel);

	labels.add(Box.createRigidArea(new Dimension(0, 10)));

	keyLabel = new JLabel("Change Secret ");
	keyLabel.setForeground(Color.red);
	labels.add(keyLabel);

	labels.add(Box.createRigidArea(new Dimension(0, 10)));

	validationLabel = new JLabel("Validate Secret ");
	validationLabel.setForeground(Color.red);
	labels.add(validationLabel);

	Box fields = Box.createVerticalBox();
	fields.add(Box.createRigidArea(new Dimension(0, 150)));

	titleField = new JTextField(25);
	titleField.setText(current.getTitle());
	fields.add(titleField);

	fields.add(Box.createRigidArea(new Dimension(0, 10)));

	keyField = new JPasswordField(25);
	fields.add(keyField);

	fields.add(Box.createRigidArea(new Dimension(0, 10)));

	validationField = new JPasswordField(25);
	fields.add(validationField);

	Box buttons = Box.createVerticalBox();
	buttons.add(Box.createRigidArea(new Dimension(0, 150)));
	
	save = new JButton("Save");
	save.setBackground(Color.red);
	save.setOpaque(true);
	save.setForeground(Color.white);
	save.setPreferredSize(new Dimension(100, 20));

	JPanel saveFrame = new JPanel();
	saveFrame.add(save);
	buttons.add(saveFrame);

	delete = new JButton("Delete");
	delete.setBackground(Color.red);
	delete.setOpaque(true);
	delete.setForeground(Color.white);
	delete.setPreferredSize(new Dimension(100, 20));

	JPanel deleteFrame = new JPanel();
	deleteFrame.add(delete);
	buttons.add(deleteFrame);

	JPanel flowFrame = new JPanel(new FlowLayout());
	flowFrame.add(labels);
	flowFrame.add(fields);
	flowFrame.add(buttons);
	flowFrame.setBorder(BorderFactory.createLineBorder(Color.black));
	flowFrame.setBackground(Color.white);
	
	back = new JButton("Back");
	back.setBackground(Color.red);
	back.setOpaque(true);
	back.setForeground(Color.white);
	back.setPreferredSize(new Dimension(200, 40));

	JPanel backFrame = new JPanel();
	backFrame.add(back);
	buttons.add(backFrame);

	JPanel frame = new JPanel(new BorderLayout());
	frame.setPreferredSize(new Dimension(1000, 500));
	frame.add(bannerFrame, BorderLayout.PAGE_START);
	frame.add(flowFrame, BorderLayout.CENTER);
	frame.add(backFrame, BorderLayout.PAGE_END);
	add(frame);
    }
}
