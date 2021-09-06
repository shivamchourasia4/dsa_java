import java.util.Scanner;

public class recwildcardpatmatch {

  /*  public static boolean recfn(String txt,String pat,int n,int m) {
        if(n==0&&m==0)
        {
            return true;
        }
        if(m==0&&n!=0)
        {
            return false;
        }
        if(n==0&&pat.charAt(m-1)=='*')
        {
            return recfn(txt, pat, n, m-1);//very imp line
        }
        else if(n==0&&pat.charAt(m-1)!='*')
        {
            return false;
        }
        if(txt.charAt(n-1)==pat.charAt(m-1)||pat.charAt(m-1)=='?')
        {
            return recfn(txt, pat, n-1, m-1);
        }
        else if(pat.charAt(m-1)=='*')
        {
            return recfn(txt, pat, n-1, m)||recfn(txt, pat, n, m-1);
        }
        else //if(txt.charAt(n-1)!=txt.charAt(m-1))
        {
            return false;
        }
        
    }*/
    //------------MEMOIZED VERSION ------------------------
    public static int recfn(String txt,String pat,int n,int m,int t[][]) {
        if(t[n][m]!=-1)
        {
            return t[n][m];
        }
        if(n==0&&m==0)
        {
           return t[n][m]= 1;
        }
        if(m==0&&n!=0)
        {
           return t[n][m] =0;
        }
        if(n==0&&pat.charAt(m-1)=='*')
        {
           return t[n][m] =recfn(txt, pat, n, m-1,t);//very imp line
        }
        else if(n==0&&pat.charAt(m-1)!='*')
        {
           return t[n][m]= 0;
        }
        if(txt.charAt(n-1)==pat.charAt(m-1)||pat.charAt(m-1)=='?')
        {
            return t[n][m]= recfn(txt, pat, n-1, m-1,t);
        }
        else if(pat.charAt(m-1)=='*')
        {
            return t[n][m] = Math.max(recfn(txt, pat, n-1, m,t),recfn(txt, pat, n, m-1,t));
        }
        else //if(txt.charAt(n-1)!=txt.charAt(m-1))
        {
            return 0;
        }
        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pat = sc.nextLine();
        int t[][] = new int[txt.length()+1][pat.length()+1];
        for(int i=0;i<txt.length()+1;i++)
        {
            for(int j=0;j<pat.length()+1;j++)
            {
                t[i][j] = -1;
            }
        }
        int ans = recfn(txt,pat,txt.length(),pat.length(),t);
        System.out.println(ans==1?true:false);
        sc.close();
    }
}