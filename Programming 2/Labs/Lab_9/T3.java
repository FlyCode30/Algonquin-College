package application;

public class T3 extends Thread{

	public void run() {

		for (int k = 1; k <= 20; k++) {
			if (k == 10)
				try {
					sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			System.out.println("C: " + k);
		}

		System.out.println("Exit from A");
	}
}
