import java.util.*;
public class memo3dblnprth {
    // ans is mod 1003 as per gfg
    
    public static int parth(String str,int i,int j,boolean isTrue,int t[][][]){
        int rek = isTrue==true?1:0;
       
        if(i>j)
        {
            return 0;
        }
        
        if(i==j)
        {
            if(isTrue)
              /*  if(str.charAt(i)=='T')
                    return t[i][j][rek]=1;
                else
                   return t[i][j][rek]=0;
            }
            else{
                 if(str.charAt(i)=='F')
                    return t[i][j][rek]=1;
                else
                   return t[i][j][rek]=0;*/
            {
                return t[i][j][rek]=(str.charAt(i)=='T')?1:0;
            }
            else
                return t[i][j][rek]=(str.charAt(i)=='F')?1:0;
        }
        
        if(t[i][j][rek]!=-1)
        {
            return t[i][j][rek];
        }

        int ans =0;
        for(int k=i+1;k<=j-1;k+=2)
        {
            int lt = parth(str, i, k-1, true,t);
            int lf = parth(str, i, k-1, false,t);
            int rt = parth(str, k+1, j, true,t);
            int rf = parth(str, k+1, j, false,t);

            if(str.charAt(k)=='&')
            {
                if(isTrue)
                    ans = (ans+(lt*rt)%1003)%1003;
                else
                    ans = (ans + (lf*rt)%1003 + (lf*rf)%1003 + (lt*rf)%1003)%1003;
            }
            else if(str.charAt(k)=='|')
            {
                if(isTrue)
                {
                    ans = (ans + (lt*rt)%1003 + (lt*rf)%1003 + (lf*rt)%1003)%1003;
                }
                else{
                    ans = (ans + (lf*rf)%1003)%1003;
                }
            }
            else if(str.charAt(k)=='^')
            {
                if(isTrue)
                {
                    ans = (ans + (lf*rt)%1003 + (rf*lt)%1003)%1003;
                }
                else{
                    ans = (ans + (lt*rt)%1003 + (lf*rf)%1003)%1003;
                }
            }
        }
        return t[i][j][rek]=(ans%1003);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
       /* String a[] = new String[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.next();
        }
        sc.nextLine();
        int m = sc.nextInt();
        String b[] = new String[m];
        for(int i=0;i<m;i++)
        {
            b[i] = sc.next();
        }

        StringBuilder s = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            s.append(a[i]);
            if(i==n-1)
                break;
            s.append(b[i]);
        }
        String str = s.toString();
        System.out.println(str);*/
        String str = sc.nextLine();
        System.out.println(str.length());
         int[][][] t = new int[str.length()+1][str.length()+1][3];
         for(int row[][]:t)
         {
             for(int col[]:row)
             {
                 Arrays.fill(col, -1);
             }
         }
        int ans = parth(str,0,str.length()-1,true,t);
        System.out.println(ans);
        sc.close();
    }
}