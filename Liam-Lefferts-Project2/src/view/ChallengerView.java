package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import component.Feed;
import component.Profile;
import model.Champion;
import model.Database;
import utils.Decorator;

public class ChallengerView extends JPanel {
    private boolean following = false;

    private Champion current;
    private Champion selected;

    private JLabel banner;

    private Profile champion;
    private Feed feed;

    public boolean getFollowing() {
	return following;
    }

    public void setFollowing(boolean following) {
	this.following = following;
    }

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public Champion getSelected() {
	return selected;
    }

    public void setSelected(Champion selected) {
	this.selected = selected;
    }

    public JLabel getBanner() {
	return banner;
    }

    public void setBanner(JLabel banner) {
	this.banner = banner;
    }

    public Profile getChampion() {
	return champion;
    }

    public void setChampion(Profile champion) {
	this.champion = champion;
    }

    public Feed getFeed() {
	return feed;
    }

    public void setFeed(Feed feed) {
	this.feed = feed;
    }

    public void refresh() {
	refreshFollowing();
	feed.populate(selected, following);
	revalidate();
	repaint();
    }

    public void refreshFollowing() {
	Database data = Database.getInstance();
	following = data.connected(current, selected);
    }

    public void addBackListener(ActionListener b) {
	champion.addBackListener(b);
    }

    public void addFollowListener(ActionListener f) {
	champion.addFollowListener(f);
    }

    public ChallengerView(Champion current, Champion selected) {
	this.current = current;
	this.selected = selected;

	refreshFollowing();
	setLayout(new BorderLayout(0, 0));

	JPanel bannerFrame = new JPanel();
	setBanner(new JLabel("Code Champions"));
	banner.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 26);
	Decorator.setFontColor(banner, "red");
	bannerFrame.setBackground(Color.white);
	bannerFrame.setLayout(new BorderLayout());
	bannerFrame.add(banner, BorderLayout.WEST);

	JPanel championFrame = new JPanel();
	setChampion(new Profile(selected, following));
	championFrame
		.setLayout(new BoxLayout(championFrame, BoxLayout.PAGE_AXIS));
	championFrame.add(champion);

	JPanel feedFrame = new JPanel();
	feedFrame.setLayout(new BorderLayout(0, 0));
	feedFrame.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	feed = new Feed(true);
	feedFrame.add(feed, BorderLayout.CENTER);

	
	
	add(championFrame, BorderLayout.WEST);
	add(feedFrame, BorderLayout.CENTER);
	add(bannerFrame, BorderLayout.NORTH);
    }
}
