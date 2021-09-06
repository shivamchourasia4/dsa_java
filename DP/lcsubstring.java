import java.util.Scanner;

public class lcsubstring {
    public static int dplcs(String s1,String s2,int n,int m){
        int t[][] = new int[n+1][m+1];
        int maxv =0;
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0){
                    t[i][j]=0;
                    continue;
                }
                if(j==0)
                {
                    t[i][j]=0;
                    continue;
                }
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                    maxv = Math.max(maxv, t[i][j]);

                }
                else{
                    t[i][j] =0;
                }
            }
        }
        /*for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }*/
        return maxv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int ans = dplcs(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
        sc.close();
    }
}