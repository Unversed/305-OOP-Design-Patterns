package model;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database uniqueInstance;
    static Connection connection = null;
    private static String url = "jdbc:sqlite:src/databaseFile/CodeChampions.db";

    public boolean authChampion(Champion current, String title, String key) {
	return Champion.authChampion(current, title, key);
    }

    public boolean addChampion(Champion current, String title, String hash) {
	return Champion.addChampion(current, title, hash);
    }

    public boolean hasChampion(String title) {
	return Champion.hasChampion(title);
    }

    public boolean updateChampion(Champion current, String title, String key) {
	return Champion.updateChampion(current, title, key);
    }

    public boolean updateImage(Champion current) {
	return Champion.updateImage(current);
    }

    public void deleteChampion(Champion current) {
	Champion.deleteChampion(current);
    }

    public void deleteConnections(Champion current) {
	try (Connection connect = this.connection()) {
	    String query = "DELETE FROM Connections WHERE connector=? OR connected=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());
	    statement.setInt(2, current.getId());
	    statement.executeUpdate();

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void deleteMessages(Champion current) {
	Message.deleteMessages(current);
    }

    public void deleteAll(Champion current) {
	deleteChampion(current);
	System.out.println("Model Deleted");
	deleteConnections(current);
	System.out.println("Connections Deleted");
	deleteMessages(current);
	System.out.println("Messages Deleted");
    }

    public boolean addMessage(Champion current, String text) {
	return Message.addMessage(current, text);
    }

    public ArrayList<Message> getMessages(Champion current) {
	return Message.getMessages(current);
    }

    public ArrayList<Message> getCurrentMessages(Champion current) {
	return Message.getCurrentMessages(current);
    }

    public ArrayList<Champion> connections(Champion current) {
	ArrayList<Champion> connections = new ArrayList<>();

	try (Connection connect = this.connection()) {
	    String query = "SELECT * FROM Connections\n"
		    + "INNER JOIN Champions ON id = connected\n"
		    + "WHERE connector = ?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());

	    ResultSet result = statement.executeQuery();

	    while (result.next()) {
		int id = result.getInt("id");
		String title = result.getString("title");
		String url = result.getString("imgURL");
		connections.add(new Champion(id, title, url));
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Connections Loaded");

	return connections;
    }

    public boolean connected(Champion connector, Champion connected) {
	try (Connection connect = this.connection()) {
	    String query = "SELECT * FROM Connections WHERE connector=? AND connected=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, connector.getId());
	    statement.setInt(2, connected.getId());

	    ResultSet result = statement.executeQuery();

	    if (result.next()) {
		System.out.println("Champions Connected");
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return false;
    }

    public boolean connect(Champion connector, Champion connected) {
	try (Connection connect = this.connection()) {
	    String query = "INSERT INTO Connections (connector, connected) VALUES (?, ?);";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, connector.getId());
	    statement.setInt(2, connected.getId());

	    if (statement.executeUpdate() > 0) {
		System.out.println("Follow Successful");
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Follow Unsuccessful");
	return false;
    }

    public boolean unconnect(Champion connector, Champion connected) {
	try (Connection connect = this.connection()) {
	    String query = "DELETE FROM Connections WHERE connector=? AND connected=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, connector.getId());
	    statement.setInt(2, connected.getId());

	    if (statement.executeUpdate() > 0) {
		System.out.println("Follow Successful");
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Unfollow Unsuccessful");
	return false;
    }

    public ArrayList<Champion> search(String search) {

	ArrayList<Champion> results = new ArrayList<>();

	try (Connection connect = this.connection()) {
	    String query = "SELECT * FROM Champions WHERE title LIKE '%"
		    + search + "%';";

	    PreparedStatement statement = connect.prepareStatement(query);
	    ResultSet result = statement.executeQuery();

	    while (result.next()) {
		int id = result.getInt("id");
		String title = result.getString("title");
		String url = result.getString("imgURL");

		results.add(new Champion(id, title, url));
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return results;
    }

    Connection connection() {
	connection = null;

	try {
	    connection = DriverManager.getConnection(url);
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	return connection;
    }

    public static Database getInstance() {
	if (uniqueInstance == null) {
	    uniqueInstance = new Database();
	}

	return uniqueInstance;
    }

    private Database() {
	connection();
    }
}
