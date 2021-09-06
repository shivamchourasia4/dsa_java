import java.util.regex.*;

public class regx {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("[00-90-9]||[10-90-9]||[20-50-5][.]");//[0-2]?[0-9]?[0-9][.]
        Matcher mat = pat.matcher("3.");
        boolean f = mat.matches();
        if(f)
        {
            System.out.println("MATCH");
        }
        else{
            System.out.println("NOT");
        }
        
    }
}