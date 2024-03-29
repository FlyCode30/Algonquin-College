package application;

public class T2 extends Thread {
	
	public void run() {
		
		for (int j = 1; j <= 20; j++) {
			
			System.out.println("B: " + j);
		}
		
		System.out.println("Exit from B");
	}
}
