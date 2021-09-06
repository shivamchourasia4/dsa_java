import java.util.*;

public class eqsumpart {

    public static boolean ifpart(int a[] ,int n)
    {
        int sum =0;
        for(int i:a)
        {
            sum+=i;
        }
        if(sum%2!=0)
        {
            return false;
        }
        else{
            boolean t[][] = new boolean[n+1][(sum/2)+1];
            for(int i=0;i<n+1;i++)
            {
                for(int j=0;j<(sum/2)+1;j++)
                {
                    if(i==0&&j==0)
                    {
                        t[i][j] = true;
                        continue;
                    }
                    if(i==0)
                    {
                        t[i][j] = false;
                        continue;
                    }
                    if(j==0)
                    {
                        t[i][j] = true;
                        continue;
                    }
                    if(a[i-1]<=j)
                    {
                        t[i][j] = t[i-1][j-a[i-1]]||t[i-1][j];
                    }
                    else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            for(int i=0;i<n+1;i++)
            {
                for(int j=0;j<(sum/2)+1;j++)
                {
                    System.out.print(t[i][j]+" ");
                }
            System.out.println();
            }
            return t[n][(sum/2)];
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        boolean ans = ifpart(a,n);
        System.out.println(ans);
        sc.close();
    }
}