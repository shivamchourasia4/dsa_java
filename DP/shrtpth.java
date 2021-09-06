import java.util.ArrayList;
import java.util.Scanner;

public class shrtpth {

    public static int recfn(int num){
        if(num%2==0)
        {
            return num/2;
        }
        else{
            int tbp = Integer.MIN_VALUE;
        for(int i=1;i<num;i++)
        {
            if(num%i==0)
            {
                if(i>tbp)
                {
                    tbp = i;
                }
            }
        }
        return tbp;
    }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m,n;
        if(a>b)
        {
            m=a;
            n=b;
        }
        else{
            m=b;
            n=a;
        }

        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        int lrgf1=m;
        a1.add(lrgf1);
        while(lrgf1!=1)
        {
            lrgf1 = recfn(lrgf1);
            a1.add(lrgf1);
        }
       // System.out.println(a1);

       // int lrgf1=recfn(m);
        int lrgf2 = n;
        a2.add(lrgf2);
        while(lrgf2!=1)
        {
            lrgf2 = recfn(lrgf2);
            a2.add(lrgf2);
        }
       // Collections.reverse(a2);
  //  System.out.println(a2);
   
       // int cnt=0;
        ArrayList<Integer> a3 = new ArrayList<>();

    for(int i=0;i<a1.size();i++)
    {    int g=0;
        for(int j=0;j<a2.size();j++)
        {
           // System.out.println("ai=> "+a1.get(i)+" aj=> "+a2.get(j));
            
             if(a1.get(i)==a2.get(j)&&a1.get(i)!=1){
                a3.add(a1.get(i));
                g=2;
                break;
            }
            if(a1.get(i)==a2.get(j)&&a1.get(i)==1)
            {
              //  a3.add(a1.get(i));
                g=1;
                 break;
            }
            //if(!a3.contains(a2.get(j)))
              // a3.add(a2.get(j));
        }
        if(g==2)
        {
            break;
        }
        if(g==1)
        {
            for(int k=0;k<a2.size();k++)
            {
                a3.add(a2.get(k));
            }
            break;
        }
        if(g==0)
        {
            //if(!a3.contains(a1.get(i)))
               a3.add(a1.get(i));
        }
    }
   // System.out.println(a3);
        int ans = a3.size()-1;
        System.out.print(ans);
        sc.close(); 
    }
}