package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Message {
    private String champion;
    private String text;

    public String getChampion() {
	return champion;
    }

    public String getText() {
	return text;
    }

    public Message(String champion, String text) {
	this.champion = champion;
	this.text = text;
    }

    static void deleteMessages(Champion current) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "DELETE FROM Messages WHERE champion_id=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());
	    statement.executeUpdate();

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    static boolean addMessage(Champion current, String text) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "INSERT INTO Messages (champion_id, text, timestamp) VALUES (?, ?, ?);";
	    String time = new Date().toString();
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());
	    statement.setString(2, text);
	    statement.setString(3, time);

	    if (statement.executeUpdate() > 0) {
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Message Initialization Failed");

	return false;
    }

    static ArrayList<Message> getMessages(Champion current) {
	ArrayList<Message> messages = new ArrayList<>();

	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "SELECT DISTINCT * FROM\n"
		    + "(SELECT  ch1.title, m.text, timestamp FROM Champions ch\n"
		    + "INNER JOIN Connections c ON ch.id = c.connector\n"
		    + "INNER JOIN Messages m ON m.champion_id = c.connector OR m.champion_id = connected\n"
		    + "INNER JOIN Champions ch1 ON m.champion_id = ch1.id\n"
		    + "WHERE ch.id = ? \n" + "	UNION ALL\n"
		    + "SELECT title, text, timestamp FROM Champions ch\n"
		    + "INNER JOIN Messages ON ch.id = champion_id\n"
		    + "WHERE ch.id = ?) temp\n" + "ORDER BY timestamp DESC;";
	    PreparedStatement statement = CCDB.connection
		    .prepareStatement(query);
	    statement.setInt(1, current.getId());
	    statement.setInt(2, current.getId());
	    ResultSet result = statement.executeQuery();

	    while (result.next()) {
		String title = result.getString("title");
		String text = result.getString("text");

		messages.add(new Message(title, text));
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Loaded All Champion Messages");

	return messages;
    }

    static ArrayList<Message> getCurrentMessages(Champion current) {
	ArrayList<Message> messages = new ArrayList<>();

	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "SELECT * FROM Messages WHERE champion_id=?";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());
	    ResultSet result = statement.executeQuery();

	    while (result.next()) {
		String text = result.getString("text");
		messages.add(new Message(current.getTitle(), text));
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Current Champion Messages Loaded");

	return messages;
    }
}
