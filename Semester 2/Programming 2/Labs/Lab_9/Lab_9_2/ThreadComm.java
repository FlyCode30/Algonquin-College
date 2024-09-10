package wait_notify;

public class ThreadComm {

	public static void main (String args[])	{
		
		// create a new customer
		final Customer c = new Customer();
		Thread t1 = new Thread()	{
			
			public void run() {
				c.withdraw(5000);
				System.out.println("After widthrasw si : " + c.amount);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				c.deposit(10000);
				System.out.println("dont' give a fuck is " + c.amount);
			}
		};
		t1.start();
		t2.start();
		
	}
}
