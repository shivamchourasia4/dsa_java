import java.util.Scanner;

public class mininsdel {

    public static int reqlcs(String s1,String s2,int m,int n){
        int t[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int rlcs = reqlcs(s1,s2,s1.length(),s2.length());
        int dels = s1.length()-rlcs;
        int ins = s2.length()-rlcs;
        System.out.println("ins=> "+ins);
        System.out.println("dels=> "+dels);
        sc.close();
    }
}