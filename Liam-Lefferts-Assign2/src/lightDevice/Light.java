package lightDevice;

public class Light {
	private boolean on;
	String location = "";

	public Light(String location) {
		this.location = location;
		this.on = false;
	}

	public void on() {
		System.out.println(location + " light is on");
		this.setOn(true);
	}

	public void off() {
		System.out.println(location + " light is off");
		this.setOn(false);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
