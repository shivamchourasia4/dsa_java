
class demo {
	static int a = 10; // A variable declared with the keyword static is called a class variable

	static {
		System.out.println("static block initialized!");
	}

	static void meth() {
//		this.a+=5; // cannot use this and super in static
		a += 5;
	}
}

//When object of class are made, no copy of the static variable is mode,
//instead all instance of the variable share the same variable (acts like global variables)

public class staticDemo {
	public static void main(String[] args) { // main is declared as static as, it must be called before any obj exists

		System.out.println(demo.a);
		demo.meth(); // Outside its class, static's are called by <className>.method() or variable
		System.out.println(demo.a);

//		o/p->
//		static block initialized! //executed only once when class is loaded
//		10
//		15

//static methods can only directly call other static methods
		// only directly access static data
	}

}
