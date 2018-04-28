package tvDevice;
import command.Command;

public class TVOff implements Command {
	TV tv;

	public TVOff(TV tv) {
		this.tv = tv;
	}

	public void execute() {
		tv.off();
	}
}
