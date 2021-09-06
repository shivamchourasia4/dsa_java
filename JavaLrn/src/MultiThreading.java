public class MultiThreading {

	public static void main(String[] args) {


//		Thread t = Thread.currentThread();
//		System.out.println(t.getName() + " " + t);
////        main Thread[main,5,main] <- Thread name, priority, name of group
//		t.setName("Oscillate");

//		System.out.println(t.getName() + " " + t);
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(i);
//            t.sleep(1000);  this also works(here we are just calling sleep on the reference
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Main thread interrupted!");
		}

		// Two ways to implement a Thread:
		// -> implement the Runnable interface
		// -> Extend the thread class itself

	}
}
