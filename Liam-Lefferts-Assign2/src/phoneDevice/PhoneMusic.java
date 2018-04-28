package phoneDevice;
import command.Command;

public class PhoneMusic implements Command {
		private Phone phone;
		
		public PhoneMusic(Phone phone) {
			this.phone = phone;
		}
		
		@Override
		public void execute() {
			phone.playMusic();
		}

	}
