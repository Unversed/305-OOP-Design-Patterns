package singleton;

public class ThreadDriver {
	public static void main (String args[]) {
		//ChocolateBoilerSingleton uniqueinstance =ChocolateBoilerSingleton.getInstance();
		//Runnable r1= new ChocolateThread (uniqueinstance);
		//Runnable r2= new ChocolateThread (uniqueinstance);
		Runnable r1= new ChocolateThread ();
		Runnable r2= new ChocolateThread ();
		//Runnable r3= new ChocolateThread ();
		
		Thread thread1= new Thread (r1);
		Thread thread2= new Thread (r2);
		//Thread thread3= new Thread (r3);
		
		thread1.start();
		thread2.start();
		//thread3.start();
	}

}
