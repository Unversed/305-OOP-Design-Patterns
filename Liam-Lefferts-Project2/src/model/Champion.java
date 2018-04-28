package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Champion {
    private int id;

    private String title;
    private String imgURL;

    private final String DEFAULT_IMG = "src/images/Default.png";
    private final String DEFAULT_TITLE = "Default";

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getImgURL() {
	return imgURL;
    }

    public void setImgURL(String imgURL) {
	if (imgURL == null)
	    return;

	this.imgURL = imgURL;
    }

    public void setAll(int id, String title, String imgURL) {
	if (id != 0)
	    this.id = id;
	if (title != null)
	    this.title = title;
	if (imgURL != null)
	    this.imgURL = imgURL;
    }

    public Champion() {
	this.id = -1;
	this.title = DEFAULT_TITLE;
	this.imgURL = DEFAULT_IMG;
    }

    public Champion(int id, String title, String url) {
	this.id = id;
	this.title = title;
	this.imgURL = url;
    }

    static boolean authChampion(Champion current, String title, String key) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query, token, imgURL;
	    query = "SELECT * FROM Champions WHERE title=?";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setString(1, title);
	    ResultSet result = statement.executeQuery();

	    if (result.next()) {
		int id = result.getInt("id");
		token = result.getString("hash");
		imgURL = result.getString("imgURL");

		if (Authentication.verify(key, token)) {
		    current.setAll(id, title, imgURL);
		    System.out.println("Authentication Successful");
		    return true;
		}
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Authentication Failed");
	return false;
    }

    static boolean addChampion(Champion current, String title, String hash) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "INSERT INTO Champions (title, hash) VALUES (?, ?);";
	    PreparedStatement statement = connect.prepareStatement(query,
		    Statement.RETURN_GENERATED_KEYS);
	    statement.setString(1, title);
	    statement.setString(2, hash);
	    statement.executeUpdate();
	    ResultSet result = statement.getGeneratedKeys();

	    if (result.next()) {
		int id = result.getInt(1);
		current.setAll(id, title, null);
		System.out.println("Champion Initialization Successful");
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Champion Initialization Failed");

	return false;
    }

    static boolean hasChampion(String title) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "SELECT * FROM Champions WHERE title=?";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setString(1, title);
	    ResultSet result = statement.executeQuery();

	    if (result.next()) {
		System.out.println("Champion Active");
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Champion Inactive");
	return false;
    }

    static boolean updateChampion(Champion current, String title, String key) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "UPDATE Champions SET " + "title=?, " + "hash=? "
		    + "WHERE id=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setString(1, title);
	    statement.setString(2, key);
	    statement.setInt(3, current.getId());

	    if (statement.executeUpdate() > 0) {
		current.setTitle(title);
		return true;
	    }
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Champion Update Failed");
	return false;
    }

    static boolean updateImage(Champion current) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "UPDATE Champions SET imgURL=? WHERE title=?";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setString(1, current.getImgURL());
	    statement.setString(2, current.getTitle());

	    if (statement.executeUpdate() > 0) {
		return true;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("Image Update Failed");
	return false;
    }

    static void deleteChampion(Champion current) {
	Database CCDB = Database.getInstance();
	try (Connection connect = CCDB.connection()) {
	    String query = "DELETE FROM Champions WHERE id=?;";
	    PreparedStatement statement = connect.prepareStatement(query);
	    statement.setInt(1, current.getId());
	    statement.executeUpdate();

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
