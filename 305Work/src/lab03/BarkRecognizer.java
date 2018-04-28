package lab03;


public class BarkRecognizer {
	private DogDoor door;
	
	public BarkRecognizer (DogDoor door) {
		this.door=door;
	}
	
	public void Recognize (String Bark)
	{
		System.out.println( "BarkRecognizer heard a Bark");
		door.open();
	}
	
	

}