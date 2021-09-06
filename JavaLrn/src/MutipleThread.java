class MultiThread implements Runnable {
	Thread t;
	String name;

	MultiThread(String name) {
		this.name = name;
		t = new Thread(this, name);
		System.out.println("New Thread " + t);
		t.start();
	}

	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			System.out.println(name + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Exiting thread " + name);
	}
}

public class MutipleThread {
	public static void main(String[] args) {
		new MultiThread("one");
		new MultiThread("Two");
		new MultiThread("Three");

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Exiting main Thread");

	}
}
