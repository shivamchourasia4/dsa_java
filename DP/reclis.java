import java.util.*;
public class reclis {

    public static int recfn(int a[]){
      
        return antrrecfn(a,Integer.MIN_VALUE,0);
    }
    public static int  antrrecfn(int a[],int prev,int curpos) {
        if(curpos == a.length)
        {
            return 0;
        }
        int taken =0;
        if(a[curpos]>prev)
        {
            taken = 1+antrrecfn(a, a[curpos], curpos+1);
        }
        int notaken = antrrecfn(a, prev, curpos+1);
        return Math.max(taken,notaken);
    }

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int t[] = new int[n];
        for(int i=0;i<n;i++)
        {
            t[i] = -1;
        }
        int ans = recfn(arr);
        System.out.println(ans);
        sc.close();
    }
}