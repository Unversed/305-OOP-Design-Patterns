package lab04.DogDoor;


/**
 * The BarkRecognizer Class holds the responsibility of 
 * recognizing the bark of the owner's dog.
 *
 * @author Liam
 */
public class BarkRecognizer {
	
	/** The door _this_ BarkRecognizer is responsible for opening. */
	private DogDoor door;
	
	/**
	 * Instantiates a new bark recognizer and links it to a dog door instance.
	 *
	 * @param DogDoor The door _this_ BarkRecognizer is responsible for opening
	 */
	public BarkRecognizer (DogDoor door) {
		this.door=door;
	}
	
	/**
	 * Stub method for bark recognizing logic
	 *
	 * @param Bark the bark to be compared.
	 */
	public void Recognize (String Bark)
	{
		//TODO: Recognizer strategy goes here
		System.out.println( "BarkRecognizer heard a Bark");
		door.open();
	}
	
	

}