package lab04.DogDoor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The DogDoor Class.
 *
 * @author Liam
 */
public class DogDoor {
	
/** DogDoor open state */
private boolean open;

/**
 * Instantiates a new dog door, which is initially closed.
 */
public DogDoor () {
	this.open=false;
}

/**
 * Call to open the dog door and automatically close after use.
 */
public void open() {
	System.out.println("The dog door opens");
	open=true;
    Timer timer = new Timer();
    timer.schedule( new TimerTask() {
  	  
  	  public void run() {
  		  close();
  		  timer.cancel();
  	  }
  	  
    },5000);
}

/**
 * Call to close the dog door
 */
public void close() {
	System.out.println("The dog door closes");
	System.out.flush();
	open=false;
}

/**
 * Returns the dog door open state.
 *
 * @return true, if is open
 */
public boolean isopen() {
	return open;
}

}
