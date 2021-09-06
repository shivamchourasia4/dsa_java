import java.util.*;

public class cnteqsumpart {

    public static int ifpart(ArrayList<Integer> a,int n)
    {   if(n==1||n==0)
        {
            return 0;
        }
        int sum =0;
         ArrayList<Integer> s1 = new ArrayList<>();
         ArrayList<Integer> s2 = new ArrayList<>();
        for(int i:a)
        {
            sum+=i;
        }
        if(sum%2!=0)
        {
            return 0;
        }
        else{
            boolean t[][] = new boolean[n+1][(sum / 2) + 1];
            for(int i=0;i<n+1;i++)
            {
                for(int j=0;j<(sum/2)+1;j++)
                {
                    
                    if(i==0&&j==0)
                    {
                        t[i][j] = true;
                        continue;
                    }
                    if(i==0)
                    {
                        t[i][j] = false;
                        continue;
                    }
                    if(j==0)
                    {
                        t[i][j] = true;
                        continue;
                    }
                    if(a.get(i-1)<=j)
                    {
                        t[i][j] = t[i-1][(j - a.get(i - 1))] || t[i - 1][j];
                    }
                    else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }/*
            for(int i=0;i<n+1;i++)
            {
                for(int j=0;j<(sum/2)+1;j++)
                {
                    System.out.print(t[i][j]+" ");
                }
            System.out.println();
            }*/
            if(t[n][(sum / 2)] == false)
            {
                return 0;
            }
           int r=n;
           int crsum = (sum / 2);

            while(r>0&&crsum>=0)
            {
                if(t[r-1][crsum])
                {
                    r--;
                    s2.add(a.get(r));
                }
                else if(t[r-1][(crsum - a.get(r - 1))])
                {
                    r--;
                    crsum-=a.get(r);
                    s1.add(a.get(r));
                }
            }
            System.out.println("s1 to be recurred: "+s1);
            //System.out.println(s1.size());
            System.out.println("s2 to be recurred: "+s2);
           // System.out.println(s2.size());
            return 1+Math.max(ifpart(s1, s1.size()),ifpart(s2, s2.size()));
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
     // System.out.println("Enter the no. of elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int k = sc.nextInt();
            a.add(k);
        }
      //  int count = 0;
        int ans = ifpart(a,a.size());

        System.out.println(ans);
      //  System.out.println(s1);
      //  System.out.println(s2);
    }
        sc.close();
    }
}