package question4;

public class BankAccount {
	private double balance;
	
	public BankAccount () {
		balance=0.0;
	}
	
	protected void setBalance (double transactionAmount) {
		balance= balance+transactionAmount;
	}
	
	public double getBalance () {
		return balance;
	}


}
