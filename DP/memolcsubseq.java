import java.util.Scanner;

public class memolcsubseq {

    public static int memcode(String s1,String s2,int n,int m,int t[][])
    {
                    if(n==0||m==0)
                    {
                        return 0;
                    }
                    if(t[n][m]==-1)
                    {
                    if(s1.charAt(n-1)==s2.charAt(m-1))
                         {
                             return t[n][m] = 1+memcode(s1, s2, n-1, m-1,t);
                         }
                    else{
                             return t[n][m] = Math.max(memcode(s1, s2, n-1, m,t),memcode(s1, s2, n, m-1,t));
                            }
                    }
                else{
                     return t[n][m]; 
                }
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    int n = s1.length();
    int m = s2.length();
    int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                t[i][j] = -1;
            }
        }
    int ans  = memcode(s1,s2,n,m,t);
    System.out.println(ans);
    sc.close();
    }
}