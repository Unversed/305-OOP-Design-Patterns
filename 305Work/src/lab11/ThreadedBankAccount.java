package lab11;

public class ThreadedBankAccount implements Runnable
{
    private BankAccount account = new BankAccount();
    
    public void run()
    {
        for (int x = 0; x < 3; x++) {
        	makeDeposit((int)(100*Math.random()));
        	makeWithdrawal((int)(100*Math.random()));
            if (account.getBalance() < 0)
            {
                System.out.println("Overdrawn!");
            }
            
        }
        
    }

    private void makeWithdrawal(int d)
    {
        if (account.getBalance() >= d)
        {
            System.out.println(Thread.currentThread().getName() + " is about to make a withdrawal");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) { ex.printStackTrace(); }
            account.withdraw(d);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal $" + d);
        }
        else
        {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
    
    private void makeDeposit(int d)
    {
        if (account.getBalance() >= d)
        {
            System.out.println(Thread.currentThread().getName() + " is about to make a deposit $" + d);
            try {

                Thread.sleep((int)(1000*Math.random()));
            } catch (InterruptedException ex) { ex.printStackTrace(); }

            
            account.deposit(d);
            System.out.println(Thread.currentThread().getName() + " completes the deposit");
        }
    }
    
    

}