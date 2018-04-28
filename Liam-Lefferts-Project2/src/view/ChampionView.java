package view;

import model.Champion;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import component.Feed;
import component.MenuBar;
import component.Publish;
import component.Results;
import component.SideBar;
import component.Wall;

public class ChampionView extends JPanel {
    private Champion current;

    private JLayeredPane layeredPane;
    private JPanel frame;
    private Results results;
    private SideBar sideBar;
    private JPanel searchPanel;
    private JLabel banner;
    private JButton search;
    private JTextField searchField;
    private MenuBar menu;
    private Publish publish;
    private Wall wall;
    private Feed feed;

    public Champion getCurrent() {
	return current;
    }

    public void setCurrent(Champion current) {
	this.current = current;
    }

    public JLayeredPane getLayeredPane() {
	return layeredPane;
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
	this.layeredPane = layeredPane;
    }

    public JPanel getFrame() {
	return frame;
    }

    public void setFrame(JPanel frame) {
	this.frame = frame;
    }

    public Results getResults() {
	return results;
    }

    public void setResults(Results results) {
	this.results = results;
    }

    public SideBar getSideBar() {
	return sideBar;
    }

    public void setSideBar(SideBar sideBar) {
	this.sideBar = sideBar;
    }

    public JPanel getSearchPanel() {
	return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
	this.searchPanel = searchPanel;
    }

    public JLabel getBanner() {
	return banner;
    }

    public void setBanner(JLabel banner) {
	this.banner = banner;
    }

    public JButton getSearch() {
	return search;
    }

    public void setSearch(JButton search) {
	this.search = search;
    }

    public JTextField getSearchField() {
	return searchField;
    }

    public void setSearchField(JTextField searchField) {
	this.searchField = searchField;
    }

    public MenuBar getMenu() {
	return menu;
    }

    public void setMenu(MenuBar menu) {
	this.menu = menu;
    }

    public Publish getPublish() {
	return publish;
    }

    public void setPublish(Publish publishPanel) {
	this.publish = publishPanel;
    }

    public Feed getFeed() {
	return feed;
    }

    public void setFeed(Feed feed) {
	this.feed = feed;
    }

    public void refresh() {
	wall.populate(current);
	feed.populate(current, true);
	revalidate();
	repaint();
    }

    public void republish() {
	remove(publish);

	publish = new Publish();
	add(publish, BorderLayout.NORTH);

	revalidate();
	repaint();
    }

    public String getPublishText() {
	return publish.getText();
    }

    public String getSearchText() {
	return searchField.getText();
    }

    public void addPublishListener(ActionListener p) {
	publish.addPublishListener(p);
    }

    public void addSearchListener(ActionListener s) {
	search.addActionListener(s);
    }

    public void addSettingsListener(ActionListener s) {
	menu.addSettingsListener(s);
    }

    public void addLogOutListener(ActionListener l) {
	menu.addLogOutListener(l);
    }

    public ChampionView(Champion current) {
	this.current = current;

	JPanel bannerPanel = new JPanel(new BorderLayout());
	banner = new JLabel("Code Champions");
	banner.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));
	Decorator.setFontBold(banner);
	Decorator.setFontSize(banner, 26);
	Decorator.setFontColor(banner, "red");
	banner.setForeground(Color.red);
	bannerPanel.setBackground(Color.white);
	bannerPanel.setLayout(new BorderLayout());

	searchPanel = new JPanel();
	searchPanel.setLayout(new FlowLayout());
	searchPanel.setBorder(BorderFactory.createEmptyBorder());

	searchField = new JTextField(60);
	searchField.setText("");
	searchPanel.add(searchField);

	search = new JButton("Search");
	search.setBackground(Color.RED);
	search.setOpaque(true);
	search.setForeground(Color.white);
	searchPanel.add(search);
	searchPanel.setBackground(Color.white);

	menu = new MenuBar();

	bannerPanel.add(banner, BorderLayout.WEST);
	bannerPanel.add(searchPanel, BorderLayout.CENTER);
	bannerPanel.add(menu, BorderLayout.EAST);

	Box feedBox = Box.createVerticalBox();
	feedBox.setBorder(BorderFactory.createEmptyBorder());

	publish = new Publish();
	feed = new Feed(false);
	wall = new Wall();
	feedBox.add(publish);
	feedBox.add(wall);
	feedBox.add(feed);

	results = new Results();

	sideBar = new SideBar(current);

	frame = new JPanel();
	frame.setLayout(new BorderLayout(0, 0));
	frame.add(bannerPanel, BorderLayout.NORTH);
	frame.add(sideBar, BorderLayout.WEST);
	frame.add(feedBox, BorderLayout.CENTER);
	frame.setBounds(0, 0, 1200, 800);

	layeredPane = new JLayeredPane();
	layeredPane.setPreferredSize(new Dimension(1200, 800));
	layeredPane.add(frame, 0);
	layeredPane.add(results, 1);
	add(layeredPane);
    }
}
