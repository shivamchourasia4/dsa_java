import java.util.*;

class qb{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> al = new ArrayList<>();
        while(n-- >0)
        {
            int s[] = new int[3];
            String nu = sc.next();
           // String su = Integer.toString(nu);
            for(int i=0;i<3;i++)
            {
                s[i] = Integer.parseInt(String.valueOf(nu.charAt(i)));
            }

            int lar = Math.max(s[0],Math.max(s[1], s[2]));
            int sma = Math.min(s[0], Math.min(s[1],s[2]));

            int bs = (lar*11)+(sma*7);
            int ebs = bs%100;

         //   System.out.println("ebs=> "+ebs);
            StringBuilder su = new StringBuilder(Integer.toString(ebs));
            if(su.length()<2)
            {
                su.insert(0, "0");
            }
             //pd = Integer.parseInt(su.toString());
         //    System.out.println(su);
             char pd = su.charAt(0);
            al.add(Character.toString(pd));
        }
        al.add(0,"0");
      //  System.out.println(al);
        int ans =0;
        for(int i=1;i<al.size();i++)
        {
            if(al.get(i)=="#")
            {
                continue;
            }
            int count=0;
         //   System.out.println("i==> "+i);
            if(i%2!=0)
            {
                for(int j=i+2;j<al.size();j+=2)
                {
                  //  System.out.println("j=> "+j);
                  //  System.out.println("di=> "+al.get(i)+"dj+> "+al.get(j));
                    if(al.get(i).charAt(0)==al.get(j).charAt(0))
                    {
                        ans++;
                        count++;
                      //  System.out.println("--------cntr"+count);
                        if(count==2)
                        {
                            Collections.replaceAll(al, al.get(i), "#");
                        //    System.out.println(al);
                            break;
                        }
                    }
                }
            }
            else{
                for(int k=i+2;k<al.size();k+=2)
                {
                   // int ecnt=0;
                  //  System.out.println("k=> "+k);
                   // System.out.println("di=> "+al.get(i)+"dk+> "+al.get(k));
                    if(al.get(i).charAt(0)==al.get(k).charAt(0))
                    {
                        //ecnt++;
                        ans++;
                        count++;
                       // System.out.println("--------cntr"+count);
                        
                        if(count==2)
                        {
                         Collections.replaceAll(al,al.get(i), "#");
                        // System.out.println(al);
                        break;
                        }
                    }
                }
            }
           // System.out.println("----------");
        }

        System.out.print(ans);
       // System.out.println(al);
    }
}