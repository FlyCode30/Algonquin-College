package wait_notify;

public class Customer {

	int amount = 0;
	int flag = 0;
	
	public synchronized int withdraw (int amount) {
		System.out.println(Thread.currentThread().getName() + ": is going to widthdraw");
		if (flag == 0)	{
			try {
				System.out.println("Waiting...");
				wait();
			}
			catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("Withdraw Complete");
		return amount;
	}
	
	public synchronized void deposit (int amount)	{
		System.out.println(Thread.currentThread().getName() + " : is going to Deposit");
		this.amount += amount;
		notifyAll();
		System.out.println("Deposit Complete");
		flag = 1;
	}
}
