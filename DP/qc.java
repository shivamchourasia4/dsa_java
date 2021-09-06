import java.util.*;

public class qc {

    public static int fn(int l,int w)
    {
      //  System.out.println("l=> "+l+"w=> "+w);
        if(l==1&&w==1)
        {
            return 1;
        }
        else if(l==w)
        {
            return 1;
        }
        else{
            if(l>w)
            {
                return 1+fn(l-w,w);
            }
            return 1+fn(l,w-l);
        }
       // return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mil = sc.nextInt();
        int mal = sc.nextInt();
        int miw = sc.nextInt();
        int maw = sc.nextInt();

        int cnt = 0;
      //  int rv = fn(5,3);
       // System.out.println(rv);
        for(int i=mil;i<=mal;i++)
        {
            for(int j=miw;j<=maw;j++)
            {
                
                int rv = fn(i,j);
               // System.out.println(rv);
                cnt =cnt+rv;
            }
        }
        System.out.print(cnt);
    }
}