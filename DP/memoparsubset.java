import java.util.*;
public class memoparsubset {

    public static int fcall(int a[],int n,int sum,int t[][])
    {

        if(sum%2!=0)
        {
            return 0;
        }
        else{
            int s = sum/2;
            
            return precall( a, n, s, t);
        }
    }

    public static int precall(int a[],int n,int sum,int t[][]) {

        if(sum==0)
        {
            return 1;
        }
        if(n==0&sum!=0)
        {
            return 0;
        }

        if(t[n][sum]!=-1)
        {
            return t[n][sum];
        }

        else if(a[n-1]<=sum)
        {
            return t[n][sum] = Math.max(precall(a, n-1, sum-a[n-1], t),precall(a, n-1, sum, t));
        }
        else{
            return t[n][sum] = (precall(a,n-1,sum,t));
        }       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of test cases: ");
        int tc = sc.nextInt();
        while(tc-->0){
        System.out.println("Enter the size: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int sum =0;
        for(int i:a){
            sum+=i;
        }
        
        int t[][] = new int[n+1][(sum/2)+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<(sum/2)+1;j++)
            {
                t[i][j] =-1;
            }
        }
        int ans = fcall(a,n,sum,t);
        if(ans==1)
        {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
        sc.close();
    }
}