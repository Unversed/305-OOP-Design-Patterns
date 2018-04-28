package lab03;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	
private boolean open;

public DogDoor () {
	this.open=false;
}

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

public void close() {
	System.out.println("The dog door closes");
	System.out.flush();
	open=false;
}

public boolean isopen() {
	return open;
}

}
