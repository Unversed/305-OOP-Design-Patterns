package singleton;

public class ChocolateThread implements Runnable{
	private ChocolateBoilerSingleton uniqueinstance; 
	private static final int DELAY =10;
	
	/*public ChocolateThread (ChocolateBoilerSingleton uniqueinstance) {
		this.uniqueinstance=uniqueinstance;
	}*/
	public ChocolateThread () {
		
	}
	
	public void run () {
		try {
			ChocolateBoilerSingleton uniqueinstance =ChocolateBoilerSingleton.getInstance();
			uniqueinstance.fill();
			uniqueinstance.boil();
			uniqueinstance.drain();
			Thread.sleep(DELAY);
			
		}
		catch (InterruptedException exception)
		{
			
		}
	}

}
