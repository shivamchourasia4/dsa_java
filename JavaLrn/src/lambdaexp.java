//@FunctionalInterface
//interface Mynum { // When an interface will have exactly 1 abstract method we can say it as a
//					// functional interface
//	double getValue(); // -> by default public abstract
//}

@FunctionalInterface
interface lambda {
	int getLambda(int a, int b);
}

@FunctionalInterface
interface forconstr {
	executeLambda getConst(int a, int b);
}

class executeLambda {
	int tryLambda(int a, int b) {
		return a + b;
	}

	executeLambda() {

	}

	executeLambda(int a, int b) {
		System.out.println("Constructor method referencing " + a + " " + b);
	}
}

class staticLambda {
	public static int cab(int a, int b) {
		return a * b;
	}
}

public class lambdaexp {
	public static void main(String[] args) {

		// Anonymous class implementation
//		Mynum my = new Mynum() {
//			@Override
//
//			public double getValue() {
//				return 14.3;
//			}
//		};
//
//		System.out.println(my.getValue());
//
//		// Using lambda expression -> Functional Interface
//		Mynum m;
//		m = () -> 123.45;
//		System.out.println(" a=> " + m.getValue());
//
//		m = () -> Math.random() * 100;
//
//		System.out.println(m.getValue());

		// static method referencing
		// :: scope resolution operator
		lambda l = staticLambda::cab;
		System.out.println(l.getLambda(14, 15));

		// instance method referencing
		executeLambda ex = new executeLambda();
		lambda g = ex::tryLambda;

		System.out.println(g.getLambda(15, 15));

		// constructor referencing
		forconstr f = executeLambda::new;
		f.getConst(1, 4);
	}
}
