import java.util.Scanner;
public class abvhckdp {

    public static boolean recfn(String a,String b,int n,int m) {
        if(n==0&&m==0)
        {
            return true;
        }
        if(n==0&&m!=0)
        {
            return false;
        }
        if(n!=0&&m==0)
        {
            for(int i=m-1;i>=0;i--)
            {
                if(Character.isUpperCase(a.charAt(i)))
                {
                    return false;
                }
            }
            return true;
        }
        System.out.println("a=> "+a.charAt(n-1)+" b=> "+b.charAt(m-1));
        if(a.charAt(n-1)==b.charAt(m-1))
        {
            return recfn(a, b, n-1, m-1);
        }
        else{
            if(Character.isUpperCase(a.charAt(n-1)))
            {
                if(a.charAt(n-1)!=b.charAt(m-1))
                {
                    return false;
                }
            }
            if(Character.toUpperCase(a.charAt(n-1))==b.charAt(m-1))
                return recfn(a, b, n-1, m)||recfn(a, b, n-1, m-1);
            else 
                 return recfn(a, b, n-1, m);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
      //  String ac = a.toUpperCase();
       // System.out.println(ans);
    
       boolean ans = recfn(a,b,a.length(),b.length());
       System.out.println(ans);
       sc.close();
    }
}