import java.util.ArrayList;
import java.util.Scanner;

public class fctr3 {

    public static int fn(ArrayList<Integer> a,int n){
        ArrayList<Integer> al = new ArrayList<>();
        int z=0,o=0,t=0;
        for(int i=0;i<n;i++)
        {
            al.add(a.get(i)%3);
            if(al.get(i)==0)
            {
                z++;
            }
            else if(al.get(i)==1)
            {
                o++;
            }
            else if(al.get(i)==2)
            {
                t++;
            }
        }

       // System.out.println(al);
      //  System.out.println("z=> "+z+"o=> "+o+"t=> "+t);
        if(z==0&&o!=0&&t!=0)
        {
            return 0;
        }
        else if(z==0&&t==0&&o!=0)
        {
            return 1;
        }
        else if(z==0&&o==0&&t!=0)
        {
            return 1;
        }
        else if(z<=(t+o))
        {
            return 1;
        }
        else{
        return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int tmp = sc.nextInt();
                a.add(tmp);
            }

            int ans = fn(a,n);
            System.out.println(ans==0?false:true);
        }
        sc.close();
    }
}