package phoneDevice;
import command.Command;

public class PhoneOff implements Command {
	Phone phone;

	public PhoneOff(Phone phone) {
		this.phone = phone;
	}

	public void execute() {
		phone.off();
	}
}
