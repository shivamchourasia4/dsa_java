import java.util.Scanner;

public class absumaxsherlockhck {

    static int[][] t = new int[100005][2];

    public static int maxabsum(int b[]){
        
        int mt = 0,mr=0;
        for(int i=1;i<b.length;i++)
        {
          int curr = b[i];
          int prev = b[i-1];
          int nmt = Math.max(mt+Math.abs(curr-prev),mr+(curr-1));
          System.out.println("nmt=> "+nmt);
          int nmr = Math.max(mt+Math.abs(1-prev),mr);
          System.out.println("nmr=> "+nmr);
          mt = nmt;
          mr = nmr;

        }
        return Math.max(mt, mr);
    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            while(tc-->0){
            int n = sc.nextInt();
            int b[] = new int[n];
            for(int i=0;i<n;i++)
            {
                b[i] = sc.nextInt();
            }

            int ans = maxabsum(b);
            System.out.println(ans);
        }
            sc.close();
        }
}