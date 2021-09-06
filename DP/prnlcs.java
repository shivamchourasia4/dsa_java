import java.util.*;

class prnlcs{

    public static int[] tlcs(int[] a,int b[])
    {
        int m=a.length;
        int n=b.length;

        int c[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                {
                    c[i][j]=0;
                }
                else if(a[i-1]==b[j-1])
                {
                    c[i][j] = 1+c[i-1][j-1];
                }
                else{
                    c[i][j] = Math.max(c[i-1][j],c[i][j-1]);
                }
            }
        }
       int d= c[m][n];
       System.out.println("d=>"+d);
       int []re = new int[d];
       int e=re.length-1;
       System.out.println("e+>"+e);
       int i=m,j=n;


       while(i>0&&j>0)
       {
         if(a[i-1]==b[j-1])
        // if(c[i-1][j]==c[i][j-1])
         {
             System.out.println(a[j-1]+",");
             re[e]=a[i-1];
             e--;
             i--;
             j--;
         }
         else if(c[i-1][j]>c[i][j-1]){
            i--;
         }
         else{
             j--;
         }
       }

    return re;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int []b = new int[m];
        for(int i=0;i<m;i++)
        {
            b[i] = sc.nextInt();
        }

       int []ans = tlcs(a,b);

       for(int i:ans)
         { System.out.println(i);}
    }
}