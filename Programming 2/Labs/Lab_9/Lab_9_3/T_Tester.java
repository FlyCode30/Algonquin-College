package yet_another_one;

public class T_Tester {

	public static void main(String[] args) {
		
		// construct the shared object
		SharedResource shared = new SharedResource();
		
		// construct a new thread
		Thread t1 = new Thread()	{
			public void run() {
				try {
					shared.incrementCounterWithWait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T1: " + shared.getCounter());
			}
		};
		
		
		Thread t2 = new Thread() {
			public void run() {
				shared.incrementCounter();
				System.out.println("T2: " + shared.getCounter());
			}
		};
		t1.start();
		t2.start();

	 
	}
}
