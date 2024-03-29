package application;

public class T_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T1 obj1 = new T1();
		T2 obj2 = new T2();
		T3 obj3 = new T3();
		
		// starting the threads
		obj1.start();
		obj2.start();
		obj3.start();
		
		// setting priorities
		
		obj1.setPriority(Thread.MIN_PRIORITY);
		obj2.setPriority(Thread.NORM_PRIORITY);
		obj3.setPriority(Thread.MAX_PRIORITY);
	}
}
