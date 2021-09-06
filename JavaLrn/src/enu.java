/* Difference b/w an enum and a class
 * 
 * Basically restrictions on enums!!
 * (enums  can't be extended)
 * 
 * 1.can't inherit another class 
 * 2. enum cannot be a super class
 * 
 * 
 * Enums however inherit java.lang.Enum which provides various methods for enums
 * such as ordinal - returns index of the enum in the list
 * compareTo - compares enums ordinal values of same enums!
 * 
 * equals or == to compare two enums
 * */

public class enu {

	enum Apple {
		J, Gh, Rd, Win, Cort
	}

	// Enums are class type.
	// This means that even that they are instantiated by new ,
	// The have the same capabilities as that of a class!

	enum Mango {
		John(10), Gold(9), Red(12), Sap(15), Land(8);
		// It is to be noted here that each enumeration constant is an object of
		// its enumeration type!

		// The constructor defined for an enum is called when enumeration constant is
		// created!

		// Each enumeration has its own copy of instance variable!
		private int price; // price of each mango

		// Constructor
		Mango(int p) {
			price = p;
		}

		int getPrice() {
			return price;
		}
	}

	public static void main(String[] args) {
		Apple ap;
		ap = Apple.Rd;

		// Output an enum value
		System.out.println("Value of ap: " + ap);
		System.out.println();

		ap = Apple.Gh;
		if (ap == Apple.Gh)
			System.out.println("matched.\n");
		// Use enum to control switch
		switch (ap) {
		case J:
			System.out.println("J is red");
			break;
		case Gh:
			System.out.println("Gh is yellow");
		default:
			break;
		}

		// using values() -- returns array that contains list of enums
		// valuesOf() -- returns the enum whose value corresponds to the passed string

		Apple allApples[] = Apple.values();
		for (Apple a : allApples)
			System.out.println(a);

		System.out.println();

		ap = Apple.valueOf("Win");
		System.out.println("ap contains " + ap);

		System.out.println("___________________");
		System.out.println("Land Price of mango is: " + Mango.Land.price);

		System.out.println("Price of all manog: ");

		for (Mango m : Mango.values())
			System.out.println(m.getPrice());

	}
}