package yet_another_one;

public class SharedResource {
   //private static final SecureRandom generator = new SecureRandom();
   private int counter = 0;

   // construct a SimpleArray of a given size
	public synchronized void incrementCounter() {
		for (int i = 0; i < 20; i++) {
			counter++;
			notifyAll();
			System.out.println("T2: " + getCounter());
		}
	
	}
	
	public synchronized int getCounter() {
		return counter;
	}
	
	// method that counts up to 5, then wait
	public synchronized void incrementCounterWithWait() throws InterruptedException {
			for (int i = 0; i < 20; i++) {
				if (getCounter() >= 5 && getCounter() <= 10) {
				wait();
			} else {
				counter++;
				System.out.println("T1: " + getCounter());
			}
            
	}
	}
}
				

//if (getCounter() >= 5 && getCounter() <= 10) {
//	try {
//		wait();
//	}
//	catch (InterruptedException e) {
//		
//	}





/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/