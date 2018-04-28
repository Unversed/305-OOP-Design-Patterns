package tvDevice;
import command.Command;

public class StreamNetflix  implements Command {
		TV tv;

		public StreamNetflix(TV tv) {
			this.tv = tv;
		}

		public void execute() {
			tv.setStreamingService("Netflix");
		}
}