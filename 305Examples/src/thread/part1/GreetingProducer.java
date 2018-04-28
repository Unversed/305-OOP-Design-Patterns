package thread.part1;

public class GreetingProducer implements Runnable{
	private String greeting;
	private static final int REPETTIONS =10;
	private static final int DELAY =100;
	
	public GreetingProducer (String aGreeting) {
		greeting= aGreeting; 
	}
	
	public void run () {
		try {
			for (int i=1; i <= REPETTIONS ; i++) 
			{
				System.out.println(i + ": " + greeting);
				Thread.sleep(DELAY);
			}
		}
	
	catch (InterruptedException exception)
	{
		
	}
	}
	

}
