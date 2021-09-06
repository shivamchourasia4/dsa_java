import java.util.ArrayList;
import java.util.Scanner;

public class mvngavg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mx = sc.nextInt();
        int my = sc.nextInt();
        int n = sc.nextInt();
        double a[] = new double[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextDouble();
        }

        ArrayList<Double> amx = new ArrayList<>();
        ArrayList<Double> amy = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            int x=mx,y=my;
            if(i>=x-1)
            {
                int r = mx;
                double tbp=0;
                for(int k=r;k>=0;k--)
                    {tbp += a[i];}
                amx.add(tbp/mx);
            }
            if(i>y-1)
            {
                int r =my;
                double tbp=0;
                for(int k=r;k>=0;k--)
                    {tbp += a[i];}
                amy.add(tbp/my);
            }
        }
        System.out.println(amx);
        System.out.println(amy);
    }
}