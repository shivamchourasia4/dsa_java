import java.util.*;
// import java.lang.*;

//Program to reverse a number
public class jstcheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n1 = num;
        int rem = 0, rev = 0;
        while (num != 0) {
            rem = num % 10;
            num = num / 10;
            rev = (rev * 10) + rem;
        }
        System.out.println(rev);

        String s = Integer.toString(n1);
        StringBuilder st = new StringBuilder(s);
        st.reverse();
        String r = st.toString();
        int ans = Integer.parseInt(r);

        System.out.println(ans);

        sc.close();
    }
}
