class Gen<T extends Number> {
	T[] nums;

	Gen(T[] o) {
		nums = o;
	}

	double getAverages() {
		double sum = 0.0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i].doubleValue(); // If number is not extended, this shall raise an error!!!

		}

		return sum / nums.length;
	}

	// Method to check of averages are equal

	boolean getEqual(Gen<?> ob) {

		if (getAverages() == ob.getAverages()) {
			return true;
		}
		return false;
	}
}

public class BoundedGenerics {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5 };

//		Gen<?> g = new Gen<>(arr); //Works, Since the class is raw type, we need to add <>
		Gen<Integer> g = new Gen<>(arr);

		Double[] str = { 1.0, 2.0, 3.0, 4.0, 5.0 };

		Gen<?> g1 = new Gen<>(str);

		System.out.println(g1.getEqual(g)); // Error! when getEqaul(Gen<T> ob)

//		Gen<?> g = new Gen<>(str); Error!!

		System.out.println(g.getAverages());

	}

}
