package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Champion;

public class Connection extends JButton {
    private Champion connected;

    public void setConnected(Champion connected) {
        this.connected = connected;
    }

    public Champion getConnected() {
	return connected;
    }

    @Override
    public Dimension getPreferredSize() {
	return new Dimension(200, 30);
    }

    @Override
    public Dimension getMaximumSize() {
	return new Dimension(200, 30);
    }

    @Override
    public Dimension getMinimumSize() {
	return new Dimension(200, 30);
    }
    
    public Connection(Champion connected, ActionListener selected) {
	this.connected = connected;
	this.setText(connected.getTitle());

	this.setBackground(Color.red);
	this.setOpaque(true);
	this.setForeground(Color.white);
	this.addActionListener(selected);
    }
    
    public Connection(Champion connected) {
	this.connected = connected;
	this.setText(connected.getTitle());

	this.setBackground(Color.red);
	this.setOpaque(true);
	this.setForeground(Color.white);
    }
}
