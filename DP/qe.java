import java.util.*;

public class qe {

    public static long tre(Integer a[])
    {
        long l = 1; 
        int d = 2; 
          
        while (true) { 
            int c = 0; 
            boolean s = false; 
              
            for (int i = 0; i < a.length; i++) { 
  
                if (a[i] == 0) { 
                    return 0; 
                } 
                else if (a[i] < 0) { 
                    a[i] = a[i] * (-1); 
                } 
                if (a[i] == 1) { 
                    c++; 
                } 
  
                
                if (a[i] % d == 0) { 
                    s = true; 
                    a[i] = a[i] / d; 
                } 
            } 
  
            
            if (s) { 
                l = l * d; 
            } 
            else { 
                d++; 
            } 
  
             
            if (c == a.length) { 
                return l; 
            } 
        } 
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n+1];
            a[0]=0;
            for(int i=1;i<=n;i++)
            {
                a[i] = sc.nextInt();
            }
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=1;i<=n;i++)
            {
                int cnt= 1;
                int p =a[i];
                int ck =i;
             //   System.out.println("a[i]=> "+a[i]);
                while(p!=ck)
                {
                    cnt++;
                    p=a[p];
                  //  System.out.println(p);
                }
                if(al.contains(cnt))
                {
                    continue;
                }
                else{
                    al.add(cnt);
                }
            }
           // System.out.println(al);
            Integer[] arr = new Integer[al.size()];
            arr = al.toArray(arr);
            System.out.println(tre(arr));
        }
    }
}