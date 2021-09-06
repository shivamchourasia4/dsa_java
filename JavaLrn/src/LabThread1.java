class mult extends Thread {

	public void run() {
		System.out.println("In Thread A!");
		for (int i = 1; i < 10; i++) {
			if (i == 1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i + " X " + i + " = " + i * i);
		}
		System.out.println("Exiting Thread " + this.getClass());
	}

}

class even extends Thread {
	public void run() {
		System.out.println("In Thread B!");
		for (int i = 1; i < 10; i++) {
			if (i == 3) {
				Thread.yield();
			}
			if (i % 2 == 0)
				System.out.println(i + " is " + " even");
			else
				System.out.println(i + " is " + " odd");
		}
		System.out.println("Exiting Thread " + this.getClass());
	}
}

class factorial extends Thread {
	@SuppressWarnings("deprecation")
	public void run() {
		System.out.println("In Thread C!");
		for (int i = 1; i < 10; i++) {
			if (i == 4) {
				stop();
			}
			int f = 1;
			for (int j = i; j <= 10; j++) {
				f *= j;
			}
			System.out.println(i + " factorial is " + f);
		}
		System.out.println("Exiting Thread " + this.getClass());
	}
}

public class LabThread1 {
	public static void main(String[] args) {
		System.out.println("Id: " + Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
		mult a = new mult();
		System.out.println("Id: " + a.getId() + " Name: " + a.getName());
		factorial b = new factorial();
		System.out.println("Id: " + b.getId() + " Name: " + b.getName());
		even c = new even();
		System.out.println("Id: " + c.getId() + " Name: " + c.getName());
		a.start();
		b.start();
		c.start();
	}
}
