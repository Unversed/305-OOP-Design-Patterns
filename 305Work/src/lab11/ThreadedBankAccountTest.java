package lab11;

public class ThreadedBankAccountTest {

	public static void main(String[] args) {
		ThreadedBankAccount theJob = new ThreadedBankAccount();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("First Thread");
		two.setName("Second Thread");
		one.start();
		two.start();
	}
}
