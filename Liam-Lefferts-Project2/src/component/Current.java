package component;

import utils.Decorator;

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

public class Current extends JPanel {
    private Champion champion;

    private JPanel profileImagePanel;
    
    private JLabel banner;
    private JLabel profileImage;
    
    private ImageIcon image;
    
    private JButton select;

    public Champion getChampion() {
        return champion;
    }

    public ImageIcon getImage() {
        return image;
    }

    
    public void addUploadListener(ActionListener u) {
	select.addActionListener(u);
    }
    public void refreshPhoto() {
	profileImagePanel.removeAll();

	image.getImage().flush();
	image = new ImageIcon(champion.getImgURL());
	profileImage = new JLabel("", image, JLabel.CENTER);
	profileImage.setPreferredSize(new Dimension(200, 200));

	profileImagePanel.add(profileImage, BorderLayout.CENTER);

	revalidate();
	repaint();
    }

    public Current(Champion champion) {
	this.champion = champion;
	setLayout(new BorderLayout());

	banner = new JLabel(champion.getTitle(), JLabel.CENTER);
	banner.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 16);
	Decorator.setFontColor(banner, "red");
	
	JPanel profileNamePanel = new JPanel(new BorderLayout());
	profileNamePanel.add(banner, BorderLayout.CENTER);
	
	image = new ImageIcon(champion.getImgURL());
	profileImage = new JLabel("", image, JLabel.CENTER);
	profileImage.setPreferredSize(new Dimension(200, 200));

	profileImagePanel = new JPanel(new BorderLayout());
	profileImagePanel.add(profileImage, BorderLayout.CENTER);
			
	select = new JButton("Change Photo");
	select.setBackground(Color.red);
	select.setOpaque(true);
	select.setForeground(Color.white);
	select.setPreferredSize(new Dimension(200, 30));

	add(profileNamePanel, BorderLayout.NORTH);
	add(profileImagePanel, BorderLayout.CENTER);
	add(select, BorderLayout.SOUTH);
    }
}
