package component;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
    private JButton settings;
    private JButton logOut;
    private JButton notifications;

    public void addNotificationListener(ActionListener n) {
	notifications.addActionListener(n);
    }

    public void addLogOutListener(ActionListener l) {
	logOut.addActionListener(l);
    }

    public void addSettingsListener(ActionListener s) {
	settings.addActionListener(s);
    }

    public JButton getSettings() {
        return settings;
    }

    public void setSettings(JButton settings) {
        this.settings = settings;
    }

    public JButton getLogOut() {
        return logOut;
    }

    public void setLogOut(JButton logOut) {
        this.logOut = logOut;
    }

    public JButton getNotifications() {
        return notifications;
    }

    public void setNotifications(JButton notifications) {
        this.notifications = notifications;
    }

    public MenuBar() {
	this.setBorder(BorderFactory.createEmptyBorder());
	this.setBackground(Color.white);

	notifications = new JButton();
	try {
	    notifications.setIcon(new ImageIcon("src/images/Notifications.png"));
	    notifications.setBorder(null);
	    notifications.setBackground(Color.RED);
	} catch (Exception ex) {
	    System.out.println(ex);
	}
	add(notifications);

	settings = new JButton();
	try {
	    settings.setIcon(new ImageIcon("src/images/Settings.png"));
	    settings.setBorder(null);
	    settings.setBackground(Color.RED);
	} catch (Exception e) {
	    System.out.println(e);
	}
	add(settings);

	logOut = new JButton("Log Out");
	logOut.setBackground(Color.RED);
	logOut.setOpaque(true);
	logOut.setForeground(Color.white);
	add(logOut);

	FlowLayout flow = (FlowLayout) getLayout();
	flow.setAlignment(FlowLayout.RIGHT);
    }
}
