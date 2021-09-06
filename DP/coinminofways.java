import java.util.Scanner;

public class coinminofways {

    public static int srtafn(int a[],int n,int sum){
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++){
                if(i==0)
                {
                    t[i][j] = Integer.MAX_VALUE-1;
                    continue;
                }
                if(j==0)
                {
                    t[i][j] = 0;
                    continue;
                }
                //SPECIAL CODE VARIATION for 2nd row----------- not in gfg
               /* if(i==1)
                {
                    if(j%a[0]==0)
                    {
                        t[i][j] = j/a[0];
                    }
                    else{
                        t[i][j] = Integer.MAX_VALUE-1;
                    }
                    continue;
                }*/
                if(a[i-1]<=j)
                {
                    t[i][j] = Math.min(1+t[i][j-a[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        
        }
        return t[n][sum];

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int ans = srtafn(a,n,sum);
        System.out.println(ans);
        sc.close();
    }
}