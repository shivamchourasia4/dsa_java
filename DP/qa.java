
//Probably a CodeVita Problem

import java.util.ArrayList;
import java.util.Scanner;

public class qa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> br = new ArrayList<>();
		ArrayList<String> gr = new ArrayList<>();

		String b = sc.next();
		String g = sc.next();
		for (int i = 0; i < b.length(); i++) {
			br.add(Character.toString(b.charAt(i)));
		}
		for (int i = 0; i < g.length(); i++) {
			gr.add(Character.toString(g.charAt(i)));
		}
		// System.out.println(br);
		// System.out.println(gr);
		int cnt = n;
		for (int i = 0; i < n; i++) {
			int f = 0;
			for (int j = 0; j < n; j++) {
				// System.out.println("br=> "+br.get(i));
				// System.out.println("gr=> "+gr.get(j));
				if (br.get(i).charAt(0) == gr.get(j).charAt(0)) {
					br.set(i, "#");
					gr.set(j, "#");
					// System.out.println(br);
					// System.out.println(gr);
					cnt--;
					f = 1;
					break;
				}

			}
			if (f == 0) {
				break;
			}
		}
		System.out.print(cnt);
	}
}