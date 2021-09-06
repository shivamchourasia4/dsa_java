import java.util.Scanner;

public class codetry {

    public static int pageCount(int n, int p) {
        int frms = 0, frme = 0;
        frms = (int) p / 2;

        frme = (int) n / 2 - (int) p / 2;
        System.out.println("frms=>" + frms);
        System.out.println("frme=>" + frme);
        return Math.min(frms, frme);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int ans = pageCount(n, p);
        System.out.println(ans);
        sc.close();
    }
}