package tvDevice;

public class TV {
	boolean isSmart;
	String location;
	String streamingService;
	int channel;
	

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " TV is on");
	}

	public void off() {
		System.out.println(location + " TV is off");
	}

	public void setInputChannel() {
		this.channel = 3;
		System.out.println("Channel is set for VCR");
	}
	
	public void setStreamingService(String streamingService) {
		this.streamingService = streamingService;
		System.out.println("Streaming service switched to " + streamingService);
	}
	
	public void currentlyPlaying() {
		
		System.out.println(location + " tv currently streaming " + streamingService + "");
	}
}
