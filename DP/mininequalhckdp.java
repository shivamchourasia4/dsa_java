import java.util.Scanner;

public class mininequalhckdp {

    public static int eqfn(int a[]) {
        int min = Integer.MAX_VALUE;
        for(int y:a)
        {
            min = Math.min(y, min);
        }
        int ans = Integer.MAX_VALUE;
        for(int t=min;t>=min-4;t--) //frm min to min-4 as if it was min-5 then we could have added 5!!
        {
            int cnt=0;
            for(int v:a)
            {
                while(v>=(t+5)&&v!=t)
                {
                    v=v-5;
                    cnt++;
                }
                while(v>=(t+2)&&v!=t)
                {
                    v=v-2;
                    cnt++;
                }
                while(v>=(t+1)&&v!=t)
                {
                    v=v-1;
                    cnt++;
                }
            }
            ans = Math.min(cnt, ans);
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        int ans = eqfn(a);
        System.out.println(ans);
        sc.close();
    }
}