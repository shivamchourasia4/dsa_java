import java.util.Scanner;

public class cvcntpldrm{

    public static boolean isplndrm(String s) {
        
       /* int i=0,j=sl.length()-1;
        boolean rt = false;
        while(i<j)
        {
            if(sl.charAt(i)!=sl.charAt(j))
            {
               return rt = false;
            }
            rt = true;
            i++;
            j--; 
        }
        return rt;*/
        StringBuffer str = new StringBuffer(s);
        str.reverse();
        String rev = str.toString();
        if(s.compareTo(rev)==0)
        {
            return true;
        }
        return false;
    }

    public static int fn(int n1,int n2){
        int cnt=0,we=0;
        for(int d=n1;d<=n2;d++)
        {
            for(int h=0;h<24;h++)
            {
                for(int m=0;m<60;m++)
                {
                    for(int s=0;s<60;s++)
                    {
                        we++;
                        String hr="",mr="",sr="";
                        if(h<10)
                        {
                             hr = "0"+Integer.toString(h);
                        }
                        else{
                             hr = Integer.toString(h);
                        }
                        if(m<10)
                        {
                             mr = "0"+Integer.toString(m);
                        }
                        else{
                             mr = Integer.toString(m);
                        }
                        if(s<10)
                        {
                             sr = "0"+Integer.toString(s);
                        }
                        else{
                             sr = Integer.toString(s);
                        }
                       // System.out.println(sr);
                     String str = Integer.toString(d)+hr+mr+sr;
                    // if(sr.equals("59"))
                    // {
                      //  System.out.println(str);
                    // }
                        if(isplndrm(str))
                        {
                            //System.out.println(str);
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println("total=> "+we);
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt();
        int n2 = sc.nextInt();
        int ans = fn(n1,n2);
        System.out.println(ans);
        sc.close();
    }
}