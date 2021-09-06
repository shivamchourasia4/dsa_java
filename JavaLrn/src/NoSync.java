class callme {
//	synchronized void call(String msg) { <-  using synchronized method
	void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	Thread t;
	callme target;
	String s;

	Caller(callme T, String st) {
		s = st;
		target = T;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		synchronized (target) {

			target.call(s);
		}
	}
}

public class NoSync {

	public static void main(String[] args) {
		callme target = new callme();
		Caller obj1 = new Caller(target, "Hello");
		try {
			obj1.t.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Caller obj2 = new Caller(target, "Synchronized");
		Caller obj3 = new Caller(target, "World");

		// Wait for threads to end
		try {
//			obj1.t.join(); // waits for a thread to terminate
			obj2.t.join();
			obj3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}

}
