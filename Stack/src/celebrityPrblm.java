/* 

A celebrity is a person who is known to all but does not know anyone at a party. 
If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party 
such that if an element of row i and column j  is set to 1 it means ith person knows jth person. 
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class celebrityPrblm {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		// make sure to enter no. of test cases!
		int t = sc.nextInt();
		while (t > 0) {
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().celebrity(M, N));
			t--;
		}

		sc.close();
	}
} // } Driver Code Ends

// User function Template for Java

class Solution {
	// Function to find if there is a celebrity in the party or not.
	int celebrity(int M[][], int n) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() >= 2) {

			int x = st.pop();
			int y = st.pop();

			if (M[x][y] == 1) {
				st.push(y);
			} else {
				st.push(x);
			}

		}

		int celeb = st.pop();
		for (int i = 0; i < n; i++) {
			if (i != celeb) {
				if (M[i][celeb] == 0 || M[celeb][i] == 1) {
					return -1;
				}
			}
		}

		return celeb;
	}
}