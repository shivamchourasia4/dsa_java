import java.util.*;

class memocountsubsum{

    public static int nofzero(int a[]){
        int cnt=0;
        for(int i:a){
            if(i==0){
                cnt++;
            }
        }
        return cnt;
    }
    public static int fcall(int a[],int n,int sum,int t[][]){
        /*if(i==n)
        {
            if(sum==0)
            {
               count++;
            }
            return count;
        }*/

        if(t[n][sum]!=-1)
        {
            return t[n][sum];
        }
        if(sum==0){
           return t[n][sum] = 1;
        }
        if(n==0&&sum!=0)
        {
            return t[n][sum] =0;
        }

       else if(a[n-1]<=sum)
        {
            return t[n][sum]=(fcall(a,n-1,sum-a[n-1],t)+fcall(a,n-1,sum,t));
        }
        else{
            return t[n][sum]=fcall(a,n-1,sum,t);
        }
        //count = fcall(a, n-1, i, sum-a[n-1], count);
        //count = fcall(a, n-1, i, sum, count);
        //return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(j==0)
                    t[i][j] = (int) Math.pow(2, nofzero(a));
                else
                    t[i][j] = -1;
            }
        }
        int ans =fcall(a,n,sum,t);
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(ans);
        sc.close();
    }
}