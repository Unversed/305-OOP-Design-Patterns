package lab04.DogDoor;

/**
 * The Class DogDoorSimulator.
 *
 * @author Liam
 */

public class DogDoorSimulator {

	   /**
   	 * The main method.
   	 * Tests both the primary automatic path and 
   	 * the remote controlled alternate path 
   	 *
   	 * @throws InterruptedException the interrupted exception
   	 */
   	public static void main () throws InterruptedException {
	      DogDoor door = new DogDoor();
	      BarkRecognizer recognizer = new BarkRecognizer (door);
	      Remote remote = new Remote(door);

	      System.out.println("Dog is Barking to go out");
	      recognizer.Recognize("bark");
	      System.out.println("Dog has gone outside");
	      
	      //Simulates Dog doing his business
	      try {
	         Thread.currentThread();
	         Thread.sleep(8000);
	      }  catch (InterruptedException e) {}

	      System.out.println("Dog is all done ");
	      System.out.println("but Dog is stuck outside");
	      System.out.println("Dog starts barking");
	      recognizer.Recognize("bark");
	      System.out.println("Dog is Back inside");
	      
	      //Allows primary path to complete 
	      try {
	         Thread.currentThread();
	         Thread.sleep(6010);
	      }  catch (InterruptedException e) {}
	      
	      
	      System.out.println("\n --Alternate Path-- \n");      
	      
	      System.out.println("Dog is Barking to go out");
	      System.out.println("Gina press the button");
	      remote.pressbutton();
	      System.out.println("Dog has gone outside");
	      
	      //Simulates Dog doing his business
	      try {
	         Thread.currentThread();
	         Thread.sleep(8000);
	      }  catch (InterruptedException e) {}

	      System.out.println("Dog is all done ");
	      System.out.println("but Dog is stuck outside");
	      System.out.println("Dog starts barking");
	      System.out.println("Gina press the button");
	      remote.pressbutton();
	      System.out.println("Dog is Back inside");
	   }
	}