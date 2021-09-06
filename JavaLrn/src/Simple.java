class overload {

//	protected int p = 1000;

	void test() {
		System.out.println("test");
	}

	void test(double x) { // <- still int can initialize it.
		// Also return type also distinguishes constructors
		System.out.println("test" + x);
	}

	void test(int a, int b) {
		System.out.println("test" + a + b);
	}
}

public class Simple {

	public static void main(String[] args) {
		System.out.println("Working");
		System.out.println("Working in vs code");

		overload m = new overload();
//		System.out.println(m.p);
		m.test();
		m.test(2); // it must be noted that although the arg is double, int may also initialize it.
		// vice versa is not true!!!!!!!!!!!!!
		m.test(3, 4);
		// when objects are passed, they are passed by call by reference.
	}

}
