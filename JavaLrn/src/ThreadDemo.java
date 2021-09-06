class NewThread extends Thread {
	NewThread() {
		// Create a new, second thread
		super("Demo Thread");
		//The call super() invokes the constructor public Thread(String name)
		System.out.println("Child thread " + this);
		start();
	}

	// Run is the entry point for second thread
	public void run() //must be overridden
	{
		for (int i = 5; i > 0; i--) {
			System.out.println("Child thread " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Exiting child thread");
	}
}


class ThreadDemo{
	public static void main(String[] args) {
		new NewThread(); //Create a new Thread

		for(int i=5;i>0;i--){
			System.out.println("Main Thread: "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main Thread exiting");
	}
}