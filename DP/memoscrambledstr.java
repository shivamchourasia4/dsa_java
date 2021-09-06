import java.util.HashMap;
import java.util.Scanner;

public class memoscrambledstr {

    public static boolean slv(String a,String b,HashMap<String,Boolean> map){

        if(a.length()!=b.length())
        {
            return false;
        }
        if(a.compareTo(b)==0)
        {
            return true;
        }
        int n = a.length();
        if(n<=1)    //n==0
        {
            return false;   //true
        }
        String tbp = a+"_"+b;
        if(map.containsKey(tbp))
        {
            return map.get(tbp);
        }
        for(int i=1;i<n;i++)
        {
          
            if(slv(a.substring(0, i),b.substring(0, i),map)&&slv(a.substring(i,a.length()),b.substring(i, b.length()),map))
            {
                map.put(tbp, true);
                return true;
            }
            if((slv(a.substring(0, i),b.substring(b.length()-i,b.length()),map))&&(slv(a.substring(i, a.length()),b.substring(0, n-i),map)))
            {
                map.put(tbp, true);
                return true;
            }
        }
        map.put(tbp,false);
        return  false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        /*for(int i=1;i<a.length();i++)
        {
        System.out.println(i+" a "+a.substring(0, i)+" "+a.substring(i, a.length()));
        System.out.println(i+" b "+b.substring(i, b.length())+" "+b.substring(0,i));
        }*/
        System.out.println("_____________________________________________________");
        HashMap<String,Boolean> map = new HashMap<>();
        String tbp = a+"_"+b;
        map.put(tbp,true);
        System.out.println(map);
            boolean ans = slv(a,b,map);      
            System.out.println(ans);
        sc.close();
    }
}