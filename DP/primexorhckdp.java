import java.util.ArrayList;
import java.util.Scanner;

public class primexorhckdp {

    static int cnt=0;
    static ArrayList<Integer> al = new ArrayList<>();
    public static boolean isPrime(int num){
        System.out.println("num=> "+num);
      if(num==1||num==0)
      {
          return false;
      }
      for(int i=2;i<=num/2;i++)
      {
          if(num%i==0)
          {
              return false;
          }
      }
      System.out.println("tis 1=> "+num);
      return true;
  }
    public static int rfn(int a[],int n,int sum) {
        if(n==0)
        {
            return 0;
        }
      //  if(al.contains(a[n-1]))
      //  {
      //      return 0;
     //   }
        //al.add(a[n-1]);
        if(isPrime(sum^a[n-1]))
        {
             cnt+=1;
        }
         return rfn(a, n-1,sum^a[n-1])+rfn(a, n-1,sum);
         
    }//3511 3671 4153  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int ans = rfn(a,n,0);
       // System.out.println(ans);
        System.out.println(cnt);
      //  System.out.println(4153^3511);
        sc.close();
    }
}