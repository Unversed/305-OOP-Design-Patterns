package phoneDevice;
import command.Command;

public class PhoneOn implements Command {
	Phone phone;

	public PhoneOn(Phone phone) {
		this.phone = phone;
	}

	public void execute() {
		phone.on();
	}
}
