
public class finalDemo {

	final int a; // = 23; // either initialize it here, or within a constructor

	finalDemo() {
		this.a = 44; // can also be done
	}

	public static void main(String[] args) {
//		System.out.println(finalDemo.a); cannot do so
		System.out.println(new finalDemo().a);
		// this can be done as, we need to first create an instance of it, as non static
		// is always called on instance of some class

//		finalDemo f = new finalDemo();
//		f.a = 3;// cannot be done as it is constant
	}
}
