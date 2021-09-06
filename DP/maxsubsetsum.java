import java.util.*;

/**
 * maxsubsetsum
 */
public class maxsubsetsum {
    public static Set<String> op = new LinkedHashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long f=1;
        long cnt=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            cnt=(cnt+(Character.getNumericValue(s.charAt(i))*f*(i+1)))%1000000007;
            f=(f*10+1)%1000000007;
        }
        System.out.println(cnt);
        sc.close();
    }
}
//fails for this test case
//63007895494540748697130257211701132911672127113982917934957238363754144356260578781606111036085360074


//  -------------GENERATES ALL PERMUTATIONS-------------
/*public class maxsubsetsum {
    public static ArrayList<String> al = new ArrayList<>();
    public static Set<String> op = new LinkedHashSet<>();
    static int cnt=0;

public static void adn(String s,String ans){
    if(s.length()==0)
    {
        al.add(ans);
        return;
    }
    adn(s.substring(1),ans+s.charAt(0));

    adn(s.substring(1),ans);
}

public static void ushs(String s) {
    for(int i=0;i<s.length();i++)
    {
        for(int j=s.length();j>i;j--)
        {
            String sub = s.substring(i, j);
            if(!op.contains(sub))
            {
                cnt+=Integer.parseInt(sub);
                System.out.println("-->"+sub);
                op.add(sub);
            }

            for(int k=1;k<sub.length()-1;k++)
            {
                StringBuffer sb = new StringBuffer(sub);
                sb.deleteCharAt(k);
                if(!op.contains(sb))
                {
                    ushs(sb.toString());
                }
            }
        }
    }
}
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.next();
        adn(s,"");
        System.out.println(al);
        Set<String> po = new LinkedHashSet<String>(al);
        System.out.println("_____________");
        System.out.println(po);
        ushs(s);
        System.out.println(op);
        System.out.println(cnt);
        sc.close();
    }
}*/