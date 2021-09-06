import java.util.Scanner;

public class scsuprseq {

    public static int rtrnlcs(String s1,String s2,int n,int m){
        int t[][]= new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] =0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][m];
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
       int rlcs =  rtrnlcs(s1,s2,s1.length(),s2.length());
       System.out.println(s1.length()+s2.length()-rlcs);
       sc.close();
    }
}