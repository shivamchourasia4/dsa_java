import java.util.*;
public class cntsubwgdiff {

    public static int nofzero(int a[])
    {
        int cnt=0;
        for(int i:a){
            if(i==0)
                cnt++;
        }
        return cnt;
    }

    public static int cntpart(int a[],int sum){
        int t[][] = new int[a.length+1][sum+1];
        for(int i=0;i<=a.length;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0&&j!=0)
                {
                    t[i][j]=0;
                    continue;
                }
                if(j==0)
                {
                    t[i][j] = (int) Math.pow(2, nofzero(a));
                    continue;
                }
                if(a[i-1]<=j)
                {
                    t[i][j]= t[i-1][j-a[i-1]]+t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[a.length][sum];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the given diff: ");
        int gd = sc.nextInt();
        //reducing the problem into counting the sum!!
        int sumar =0;
        for(int i:a){
            sumar+=i;
        }
        int sum = (gd+sumar)/2;
        System.out.println("Redsum: "+sum);
        int ans = cntpart(a,sum);
        System.out.println(ans);
        sc.close();
    }
}