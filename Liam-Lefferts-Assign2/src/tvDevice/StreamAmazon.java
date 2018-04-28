package tvDevice;
import command.Command;

public class StreamAmazon  implements Command {
		TV tv;

		public StreamAmazon(TV tv) {
			this.tv = tv;
		}

		public void execute() {
			tv.setStreamingService("Amazon");
		}
}