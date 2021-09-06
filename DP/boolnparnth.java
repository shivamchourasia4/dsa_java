/*

Given a boolean expression with following symbols. 

Symbols
    'T' ---> true 
    'F' ---> false 
And following operators filled between symbols 

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true. 
Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
Examples: 

Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T)).

*/

import java.util.Scanner;

public class boolnparnth {
    public static int parth(String str, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) {
                if (str.charAt(i) == 'T')
                    return 1;
                else
                    return 0;
            } else {
                if (str.charAt(i) == 'F')
                    return 1;
                else
                    return 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = parth(str, i, k - 1, true);
            int lf = parth(str, i, k - 1, false);
            int rt = parth(str, k + 1, j, true);
            int rf = parth(str, k + 1, j, false);

            if (str.charAt(k) == '&') {
                if (isTrue)
                    ans = ans + (lt * rt);
                else
                    ans = ans + (lf * rt) + (lf * rf) + (lt * rf);
            } else if (str.charAt(k) == '|') {
                if (isTrue) {
                    ans = ans + (lt * rt) + (lt * rf) + (lf * rt);
                } else {
                    ans = ans + (lf * rf);
                }
            } else if (str.charAt(k) == '^') {
                if (isTrue) {
                    ans = ans + (lf * rt) + (rf * lt);
                } else {
                    ans = ans + (lt * rt) + (lf * rf);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        sc.nextLine();
        /*
         * String a[] = new String[n]; for(int i=0;i<n;i++) { a[i] = sc.next(); }
         * sc.nextLine(); int m = sc.nextInt(); String b[] = new String[m]; for(int
         * i=0;i<m;i++) { b[i] = sc.next(); }
         * 
         * StringBuilder s = new StringBuilder(); for(int i=0;i<n;i++) { s.append(a[i]);
         * if(i==n-1) break; s.append(b[i]); } String str = s.toString();
         * System.out.println(str);
         */
        String str = sc.nextLine();
        int ans = parth(str, 0, str.length() - 1, true);
        System.out.println(ans);
        sc.close();
    }
}