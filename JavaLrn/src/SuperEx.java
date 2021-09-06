
class top {

	private int i;
	public int f;

	top(int i) {
		this.i = i;
	}

	public int geti() {
		return i;
	}
}

class bottom extends top {

	bottom(int i) {
		super(i); // private i is accessed here
	}

	public int getf() {
		super.f = 44; // used like this, except it refers the immediate superclass f
		return super.f;
	}

}

public class SuperEx {

	public static void main(String[] args) {
		top a = new top(2);

//		System.out.println(a.i); Error as private

//		using getter
		System.out.println(a.geti());

		bottom b = new bottom(33);
		System.out.println(b.geti());
		System.out.println(b.getf());

		// super can also be used to call methods that are hidden by subclass.

	}

}
