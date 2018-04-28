package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Authentication;
import model.Champion;
import model.Database;

class DatabaseTest {

    @Test
    void testHasChampion() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	assertEquals(data.hasChampion("NULL"), false);

	assertEquals(data.hasChampion(title), false);
	data.addChampion(testChampion, title, hash);
	assertEquals(data.hasChampion(title), true);

	data.deleteAll(testChampion);
    }

    @Test
    void testAddChampion() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	assertEquals(data.hasChampion(title), false);
	assertEquals(data.addChampion(testChampion, title, hash), true);
	assertEquals(data.hasChampion(title), true);
	data.deleteAll(testChampion);
    }

    @Test
    void testDeleteAll() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	data.addChampion(testChampion, title, hash);

	assertEquals(data.hasChampion(title), true);
	data.deleteAll(testChampion);
	assertEquals(data.hasChampion(title), false);
    }

    @Test
    void testUpdate() throws Exception {
	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	assertEquals(data.addChampion(testChampion, title, hash), true);
	assertEquals(testChampion.getTitle(), title);
	assertEquals(data.updateChampion(testChampion, "confirm", hash), true);
	assertEquals(testChampion.getTitle(), "confirm");

	data.deleteAll(testChampion);
    }

    @Test
    void testActiveChampion() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testuser";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	assertEquals(data.hasChampion(title), true);
	assertEquals(data.addChampion(testChampion, title, hash), false);

	data.deleteAll(testChampion);
    }

    @Test
    void testAuthChampion() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);

	data.addChampion(testChampion, title, hash);

	assertEquals(testChampion.getTitle(), title);
	assertEquals(data.authChampion(testChampion, title, key), true);
	assertEquals(testChampion.getTitle(), title);
	assertEquals(data.authChampion(testChampion, title, "fail"), false);

	data.deleteAll(testChampion);
    }

    @Test
    void testConnect() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	assertEquals(data.connect(testChampion, testChampion2), true);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

    @Test
    void testConnected() throws Exception {

	Database data = Database.getInstance();
	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	data.connect(testChampion, testChampion2);
	assertEquals(data.connected(testChampion, testChampion2), true);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

    @Test
    void testUnconnect() throws Exception {

	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	data.connect(testChampion, testChampion2);
	assertEquals(data.connected(testChampion, testChampion2), true);
	assertEquals(data.unconnect(testChampion, testChampion2), true);
	assertEquals(data.connected(testChampion, testChampion2), false);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

    @Test
    void testConnections() throws Exception {

	Database data = Database.getInstance();
	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	data.connect(testChampion, testChampion2);
	assertEquals(data.connections(testChampion).size(), 1);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

    @Test
    void testAddMessage() throws Exception {
	Database data = Database.getInstance();
	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	String post = "Test Message";

	data.addChampion(testChampion, title, hash);
	data.authChampion(testChampion, title, key);
	assertEquals(data.addMessage(testChampion, post), true);

	data.deleteAll(testChampion);
    }

    @Test
    void testGetCurrentMessages() throws Exception {
	Database data = Database.getInstance();
	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	String post = "Test Message";

	data.addChampion(testChampion, title, hash);
	data.authChampion(testChampion, title, key);

	data.addMessage(testChampion, post);
	assertEquals(data.getCurrentMessages(testChampion).size(), 1);

	data.deleteAll(testChampion);
    }

    @Test
    void testGetMessages() throws Exception {
	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	String messsage = "Test Message";
	data.addMessage(testChampion, messsage);
	data.addMessage(testChampion2, messsage);

	assertEquals(data.getMessages(testChampion).size(), 1);
	data.connect(testChampion, testChampion2);
	assertEquals(data.getMessages(testChampion).size(), 2);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

    @Test
    void testUnconnectedGetMessages() throws Exception {
	Database data = Database.getInstance();

	Champion testChampion = new Champion();
	String title = "testChampion";
	String key = "123412341234";
	String hash = Authentication.hash(key);
	data.addChampion(testChampion, title, hash);

	Champion testChampion2 = new Champion();
	String title2 = "testChampion2";
	String key2 = "432143214321";
	String hash2 = Authentication.hash(key2);
	data.addChampion(testChampion2, title2, hash2);

	String messsage = "Test Message";
	data.addMessage(testChampion, messsage);
	data.addMessage(testChampion2, messsage);
	data.connect(testChampion, testChampion2);

	assertEquals(data.getMessages(testChampion).size(), 2);
	data.unconnect(testChampion, testChampion2);
	assertEquals(data.getMessages(testChampion).size(), 1);

	data.deleteAll(testChampion);
	data.deleteAll(testChampion2);
    }

}
