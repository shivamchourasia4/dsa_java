// interface Try {
// 	void m();

// 	void x();
// }

// class test implements Try {

// 	@Override
// 	public void m() {
// 		System.out.println("teste2");

// 	}

// }

abstract class Figure {

	int l, b;

	abstract void area();
}

class Rectangle extends Figure {

	void area() {
		System.out.println(l * b);
	}

}

public class AbstractClass {

	public static void main(String[] args) {
		// Figure f = new Figure();
		Rectangle r = new Rectangle();
		r.b = 3; // these can be accessed here as the variables are public
		r.l = 4; // had they been private, we had to use super in constructor
		r.area();

		Figure f; // dynamic method dispatch(Upcasting)
		f = r;
		f.area();

		// new test().m();

	}
}
