package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Champion;
import utils.Decorator;

public class Profile extends JPanel {
    private Champion current;

    private JLabel banner;
    private JLabel profileImage;

    private JPanel profileImagePanel;

    private JButton follow;
    private JButton back;

    public void addBackListener(ActionListener b) {
	back.addActionListener(b);
    }

    public void addFollowListener(ActionListener f) {
	follow.addActionListener(f);
    }

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public JLabel getProfileImage() {
	return profileImage;
    }

    public void setProfileImage(JLabel profileImage) {
	this.profileImage = profileImage;
    }

    public JPanel getProfileImagePanel() {
	return profileImagePanel;
    }

    public void setProfileImagePanel(JPanel profileImagePanel) {
	this.profileImagePanel = profileImagePanel;
    }

    public Profile(Champion current, boolean following) {
	this.current = current;

	setLayout(new BorderLayout());
	setBorder(BorderFactory.createLineBorder(Color.black));

	if (following)
	    follow = new JButton("Unfollow");
	else
	    follow = new JButton("Follow");

	back = new JButton("Back");

	banner = new JLabel(current.getTitle(), JLabel.CENTER);
	banner.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");

	ImageIcon image = new ImageIcon(current.getImgURL());
	profileImage = new JLabel("", image, JLabel.CENTER);
	profileImage.setPreferredSize(new Dimension(200, 200));

	profileImagePanel = new JPanel(new BorderLayout());
	JPanel profileNamePanel = new JPanel(new BorderLayout());

	profileImagePanel.add(profileImage, BorderLayout.CENTER);
	profileNamePanel.add(banner, BorderLayout.CENTER);

	JPanel buttons = new JPanel();
	follow.setBackground(Color.RED);
	follow.setOpaque(true);
	follow.setForeground(Color.white);
	follow.setPreferredSize(new Dimension(100, 20));
	buttons.add(follow);

	back.setBackground(Color.RED);
	back.setOpaque(true);
	back.setForeground(Color.white);
	back.setPreferredSize(new Dimension(100, 20));
	buttons.add(back);

	add(profileNamePanel, BorderLayout.NORTH);
	add(profileImagePanel, BorderLayout.CENTER);
	add(buttons, BorderLayout.SOUTH);

    }
}
