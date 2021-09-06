import java.util.Scanner;

public class seqpatmatch {

    public static boolean reqfn(String str1,String str2,int m,int n){
        boolean t[][] = new boolean[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0)
                {
                    t[i][j] = true;
                    continue;
                }
                if(j==0)
                {
                    t[i][j] = false;
                    continue;
                }
                else if(str2.charAt(i-1)==str1.charAt(j-1))
                {
                    t[i][j] = true;
                }
                else{
                    t[i][j] = t[i][j-1];
                }
            }
        }
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return t[n][m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int a = s1.length();
        int b = s2.length();
        //basic ques may be check whether a is substring of b
        String fs="";
        String ss="";
        if(a>=b)
        {
             fs = s1;
             ss = s2;
        }
        else{
             fs = s2;
             ss = s1;
        }
        boolean ans = reqfn(fs,ss,fs.length(),ss.length());
        System.out.println(ans);
        sc.close();
    }
}