import java.util.*;
public class rodcutting {

    public static int unbknap(int l[],int p[],int n,int r){

        int t[][] = new int[n+1][r+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<r+1;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
                else if(l[i-1]<=j)
                {
                    t[i][j] = Math.max(p[i-1]+t[i][j-l[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][r];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int n= sc.nextInt();
        int l[] = new int[n];
        int p[] = new int[n];
        System.out.println("Enter the lengths: ");
        for(int i=0;i<n;i++)
        {
            l[i]=sc.nextInt();
        }
        System.out.println("Enter the prices: ");
        for(int i=0;i<n;i++)
        {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter the rod length: ");
        int r = sc.nextInt();
        int ans = unbknap(l,p,n,r);
        System.out.println(ans);
        sc.close();
    }
}