import java.util.Arrays;
import java.util.Scanner;

public class eggdrp {
        public static int drpfn(int e,int f,int t[][]){
          //  System.out.println("e=> "+e+"f=> "+f);
          if(t[e][f]!=-1)
          {
              return t[e][f];
          }
            if(f==1||f==0)
            {
                return f;
            }
            if(e==1)
            {
                return f;
            }
            int mn = Integer.MAX_VALUE;
            for(int k=1;k<=f;k++)
            {
                int temp = 1+Math.max(drpfn(e-1, k-1,t), drpfn(e, f-k,t));    //worst case
                mn= Math.min(mn,temp);  // min attemps in worst case
            }
            return t[e][f] = mn;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int f = sc.nextInt();
        int t[][] = new int[e+1][f+1];
        for(int row[]:t)
        {
            Arrays.fill(row, -1);
        }
        int ans = drpfn(e,f,t);
        System.out.println(ans);
      //  int div = (f/e)-1;
      //  System.out.println(div);
        sc.close();
    }
}