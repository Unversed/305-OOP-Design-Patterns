package lab04.DogDoor;


/**
 * The Class Remote.
 *
 * @author Liam
 */
public class Remote {

   /** The door. */
   private DogDoor door;

   /**
    * Instantiates a new remote.
    *
    * @param door the door
    */
   public Remote (DogDoor door) {
      this.door=door;
   }

   /**
    * Stub methods simulates remote control button press, 
    * switching the state of the door
    */
   public void pressbutton() {
      System.out.println("Pressing the remote control button...");
      if (door.isopen()) {
         door.close();
      } else 
         door.open();
   }

}

