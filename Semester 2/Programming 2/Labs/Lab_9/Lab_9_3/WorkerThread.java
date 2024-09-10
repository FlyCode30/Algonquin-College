//package yet_another_one;
//
//public class WorkerThread extends Thread{
//
//	private static String nameThread;
//	private SharedResource sharedResource;
//	private int myCondition;
//	
//	public WorkerThread(String nameThread, SharedResource sharedResource, int myCondition) {
//		WorkerThread.nameThread = nameThread;
//		this.sharedResource = sharedResource;
//		this.myCondition = myCondition;
//	}
//	
//	// getter for nameThread
//	public static String getNameThread() {
//		return nameThread;
//	}
//	
//	@Override
//	public void run() {
//		 while(true) {
//			 synchronized (sharedResource) {
//				 if (sharedResource.getCounter() < myCondition) {
//					 sharedResource.incrementCounter();
//					 try {
//						sharedResource.waitForCondition("t1", 5, 10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					 System.out.printf("Thread %s: %d%n", nameThread, sharedResource.getCounter());
//				 }
//			 }
//		 }
//	}
//	
//}
			 
				
			 //sharedResource.notifyAll();

           
	
	

				
