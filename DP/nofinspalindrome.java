import java.util.Scanner;

public class nofinspalindrome {

    public static int funcall(String str,String rstr){
        int t[][] = new int[str.length()+1][rstr.length()+1];
        for(int i=0;i<str.length()+1;i++)
        {
            for(int j=0;j<rstr.length()+1;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
                else if(str.charAt(i-1)==rstr.charAt(j-1))
                {
                    t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]); 
                }
            }
        }
        return t[str.length()][rstr.length()];
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String rstr = new String(sb.reverse());
      //  System.out.println(rstr);
        int ans = funcall(str,rstr);
        //System.out.println("=> "+str.length());
       // System.out.println(ans);
        int rans = str.length()-ans;
        System.out.println(rans);
       sc.close();
    }
}