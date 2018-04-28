package question4;


public class Deposit implements Runnable {
	private double transactionAmount;
	private static final int DELAY =100;
	private BankAccount account;
	
	
	public Deposit (BankAccount account, double transactionAmount) {
		this.account=account;
		this.transactionAmount=transactionAmount;
	}
	
	public void run () {
		try {
			account.setBalance(transactionAmount);
			System.out.println(account.getBalance());
			Thread.sleep(DELAY);
		}
		catch (InterruptedException exception)
		{
			
		}
	}
	

}

