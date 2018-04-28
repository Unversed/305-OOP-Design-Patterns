package phoneDevice;

public class Phone {
	
	String owner;
	int channel;

	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void on() {
		System.out.println(owner + "'s Phone is on");
	}

	public void off() {
		System.out.println(owner + "'s Phone is off");
	}
	
	public void playMusic() {
		System.out.println(owner + "'s Playing music");
	}
}
