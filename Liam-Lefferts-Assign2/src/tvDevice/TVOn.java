package tvDevice;

import command.Command;

public class TVOn implements Command {
	TV tv;

	public TVOn(TV tv) {
		this.tv = tv;
	}

	public void execute() {
		tv.on();
	}
}
