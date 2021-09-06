import java.util.*;

public class memosubsetsum {

    
    public static int fcall(int a[] ,int n,int sum,int t[][]){

        if(sum==0)
        {
            return 1;
        }
        if(n==0&&sum!=0)
        {
            return 0;
        }
        if(t[n][sum]!=-1)
        {
            return t[n][sum];
        }

        else 
        {
            if(a[n-1]<=sum){
               return t[n][sum] = Math.max((fcall(a, n-1, sum-a[n-1],t)),(fcall(a,n-1,sum,t)));
            }
        else{
           return t[n][sum] = fcall(a, n-1, sum,t);
            }
    }   
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
        System.out.println("Enter the sum: ");
        int sum = sc.nextInt();
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                t[i][j] = -1;
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
        sc.close();
    }
}