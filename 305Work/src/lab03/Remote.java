package lab03;

public class Remote {

   private DogDoor door;

   public Remote (DogDoor door) {
      this.door=door;
   }

   public void pressbutton() {
      System.out.println("Pressing the remote control button...");
      if (door.isopen()) {
         door.close();
      } else 
         door.open();
   }

}

