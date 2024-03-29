package application;

class T1 extends Thread {
	
	public void run() {
	
		for (int i=1; i<=20; i++) {
			if (i==7) {
				Thread.yield();
			}
			System.out.println("A: " + i);
		}
		
		System.out.println("Exit from A");
	}
}
