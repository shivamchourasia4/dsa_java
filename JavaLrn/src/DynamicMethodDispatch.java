
class A {

	void display() {
		System.out.println("A call");
	}
}

class B extends A {

	void display() {
		System.out.println("B call");
	}
}

class C extends B {

	void display() {
		System.out.println("C call");
	}
}

public class DynamicMethodDispatch {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();

		A r; // obtain a reference of type A

		r = a; // refer to an A object
		r.display();

		r = b;// refer to an B object
		r.display();

		r = c;// refer to an C object
		r.display();

	}

}
