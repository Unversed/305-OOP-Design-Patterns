package thread2.part2;

public class GreetingProducer implements Runnable{
	Class1 obj;
	private String greeting;
	private static final int REPETTIONS =10;
	private static final int DELAY =100;
	public int counter;
	public int transaction;
	
	public GreetingProducer (String aGreeting, Class1 obj, int transaction) {
		greeting= aGreeting; 
		this.obj=obj;
		this.transaction=transaction;
	}
	
	public void run () {
		try {


				obj.setcounter(transaction);
				System.out.println(obj.getcounter());
				Thread.sleep(DELAY);

		}
	
	catch (InterruptedException exception)
	{
		
	}
	}
	

	

}
