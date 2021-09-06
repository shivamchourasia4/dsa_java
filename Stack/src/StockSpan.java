/* 
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock 
and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days
 just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// Basically o/p the the consecutive no. of smaller or equal to before it.
class pair {
	int val, index;

	public pair(int val, int index) {
		this.val = val;
		this.index = index;
	}
}

public class StockSpan {

	public static int[] stockspan(int a[]) {

		ArrayList<pair> al = new ArrayList<>();
		Stack<pair> st = new Stack<pair>();
		for (int i = 0; i < a.length; i++) {

			if (st.isEmpty()) {
				al.add(new pair(-1, -1));
			}

			else if (!st.isEmpty() && st.peek().val > a[i]) {
				al.add(new pair(st.peek().val, st.peek().index));
			} else if (!st.isEmpty() && st.peek().val <= a[i]) {
				while (!st.isEmpty() && st.peek().val <= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					al.add(new pair(-1, -1));
				} else {
					al.add(new pair(st.peek().val, st.peek().index));
				}
			}
			st.push(new pair(a[i], i));
		}

		int rslt[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			rslt[i] = i - al.get(i).index;
		}

		return rslt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int ans[] = stockspan(a);
		for (int i : ans) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
