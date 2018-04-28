package question4;

public class Driver {
	public static void main (String args[]) throws InterruptedException {
		BankAccount account=new BankAccount();
		System.out.println ("balance before deposit: " +account.getBalance());
		Runnable r1= new Deposit (account,156);
		Runnable r2= new Deposit (account,20);
		Runnable r3= new Deposit (account,60);
		
		Thread t1 = new Thread (r1);
		Thread t2 = new Thread (r2);
		Thread t3 = new Thread (r3);
		
		t1.start();
		t2.start();
		t3.start();
		//System.out.println(Thread.currentThread().getName());
		t1.join();
		t2.join();
		t3.join();
		System.out.println ("balance after deposit: " +account.getBalance());
		
		
	}

}
