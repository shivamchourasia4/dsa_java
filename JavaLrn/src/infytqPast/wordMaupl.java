package infytqPast;

import java.util.*;

public class wordMaupl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        ArrayList<String> al = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("#"))
                continue;
            String tmp = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))) {
                    tmp += String.valueOf(s.charAt(j));
                    s = s.replace(String.valueOf(s.charAt(j)), "#");
                }
            }
            al.add(tmp);
        }

        // System.out.println(al);
        Collections.sort(al, String::compareToIgnoreCase);
        System.out.println(al);

        String ans = "";
        for (int i = 0; i < al.size() / 2; i++) {
            ans += al.get(i) + "" + al.get(al.size() - 1 - i);
        }

        if (al.size() % 2 != 0) {
            ans += al.get(al.size() / 2);
        }
        System.out.println(ans);
        sc.close();
    }
}

// HelLoWOrld
// [‘d’, ‘e’, ‘H’, ‘lLl’, ‘oO’, ‘r’, ‘W’]