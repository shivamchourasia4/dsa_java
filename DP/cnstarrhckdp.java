import java.util.Scanner;

public class cnstarrhckdp {
    static int cnt=0;
    public static int  cntfn(int a[],int n,int k){
        if(n<=2)
        {
            return 0;
        }
       
        for(int i=1;i<=k;i++)
        {   
            if(n==3)
            {
                if(a[n-1]!=i&&a[0]!=i)
                {
                    a[(n-1)-1]=i;
                     cnt++;
                }
            }
            else if(a[n-1]!=i)
            {
                    a[(n-1)-1]=i;
                 cntfn(a, n-1, k);
            }
        }
        return 76;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        a[0] = 1;
        a[n-1] = x;
        // int val[] = new int[k];
        // int f=1;
        // for(int i=0;i<k;i++)
        // {
        //     val[i]=f;
        //     System.out.print(val[i]+" ");
        //     f++;
        // }
      //  System.out.println();
      //  System.out.println("__________");
        int ans =  cntfn(a,n,k);
        System.out.println(ans);
        System.out.println(cnt%1000000007);
        sc.close();
    }
}