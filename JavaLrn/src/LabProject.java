import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {

	String Name;

	int roll, marksMaths, marksEng, marksC;
	double avg;

	public Student(int roll, String Name, int maths, int eng, int c) {
		this.Name = Name;
		this.roll = roll;
		marksMaths = maths;
		marksEng = eng;
		marksC = c;
		avg = (marksMaths + marksEng + marksC) / 3;
	}
}

public class LabProject {

	static ArrayList<Student> db = new ArrayList<Student>();

	static void printDetailsint(Student s) {

		System.out.println("Student Name: " + s.Name);
		System.out.println("Student Roll: " + s.roll);
		System.out.println("Student English Marks: " + s.marksEng);
		System.out.println("Student Maths Marks: " + s.marksMaths);
		System.out.println("Student C Marks: " + s.marksC);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Student DataBase:");

		boolean run = true;
		try {
			while (run) {
				System.out.println(
						"Enter 1: to register to a student\nEnter 2: to view student details\nEnter 3: To Exit DataBase");
				System.out.println("Enter 4 :for reports");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:

					String name;
					int roll, eng, maths, C;
					boolean flag = false;
					System.out.println("Enter the name of the student:");
					name = sc.next();
					System.out.println("Enter the roll of the student:");
					roll = sc.nextInt();
					for (Student x : db) {
						if (x.roll == roll) {
							System.out.println("Student with that roll already exists!");
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					}
					System.out.println("Enter marks of English:");
					eng = sc.nextInt();
					System.out.println("Enter marks of Mathematics:");
					maths = sc.nextInt();
					System.out.println("Enter marks of C:");
					C = sc.nextInt();
					db.add(new Student(roll, name, maths, eng, C));
					System.out.println("Student data added into the database!");
					break;

				case 2:

					System.out.println("Enter 1: To search student using roll");
					System.out.println("Enter 2: To search student using name");
					int query = sc.nextInt();
					if (query == 1) {
						System.out.println("Enter the roll to search:");
						int rollq = sc.nextInt();
						boolean found = false;
						for (Student x : db) {
							if (x.roll == rollq) {
								printDetailsint(x);
								found = true;
							}
						}
						if (!found) {
							System.out.println("No Such Student!");
						}
					} else if (query == 2) {
						System.out.println("Enter the name to search:");
						String nameq = sc.next();
						System.out.println("Entered Data: " + nameq);
						nameq.trim();
						boolean found = false;
						for (Student x : db) {
							if (x.Name.equals(nameq)) {
								printDetailsint(x);
								found = true;
							}
						}

						if (!found) {
							System.out.println("No Such Student!");
						}
					} else {
						System.out.println("Invalid Query Choice!!!!");
					}
					break;

				case 3:
					System.out.println("BYE!");
					run = false;
					break;
				case 4:

					System.out.println("Enter 1: to get students below cumulative average marks");
					System.out.println("Enter 2: to get students below average marks in particular subjects");

					int getrepo = sc.nextInt();

					if (getrepo == 1) {
						System.out.println("Students below cumulative avg marks: ");
						for (Student x : db) {
							if (x.avg < 40) {
								System.out.println(x.Name);
							}
						}
					} else if (getrepo == 2) {

						System.out.println("Enter 1: for English\nEnter 2: for Maths\nEnter 3: for C");

						int subquery = sc.nextInt();
						if (subquery == 1) {
							System.out.println("Students below avg marks in English");
							for (Student x : db) {
								if (x.marksEng < 40) {
									System.out.println(x.Name);
								}
							}
						} else if (subquery == 2) {
							System.out.println("Students below avg marks in Maths");
							for (Student x : db) {
								if (x.marksMaths < 40) {
									System.out.println(x.Name);
								}
							}
						} else if (subquery == 3) {
							System.out.println("Students below avg marks in C");
							for (Student x : db) {
								if (x.marksC < 40) {
									System.out.println(x.Name);
								}
							}
						} else {
							System.out.println("Invalid Query!!!");
						}

					} else {
						System.out.println("Invalid query!!!");
					}

					break;
				default:
					System.out.println("Invaid query!!!!");

				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Input Type Error! Re run the program and  *Please provide proper inputs*.");
		}

		sc.close();
	}

}
