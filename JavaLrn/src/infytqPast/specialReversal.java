package infytqPast;

import java.util.*;

public class specialReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sbn = new StringBuffer();

        HashMap<Integer, String> hm = new HashMap<>();

        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isLetterOrDigit(sb.charAt(i))) {
                hm.put(i, String.valueOf(sb.charAt(i)));
            } else {
                sbn.append(String.valueOf(sb.charAt(i)));
            }
        }

        sbn.reverse();

        for (Map.Entry<Integer, String> x : hm.entrySet()) {
            sbn.insert(x.getKey(), x.getValue());
        }

        System.out.println(sbn);
        // int i = 0, j = sp.length - 1;

        // while (i < j && i < sp.length - 1 && j > 0) {

        // while (!Character.isLetterOrDigit(sp[i].charAt(0)) && i < sp.length - 2) {
        // i++;
        // }

        // while (!Character.isLetterOrDigit(sp[j].charAt(0)) && j > 1) {
        // j--;
        // }

        // String tmp = sp[i];
        // sp[i] = sp[j];
        // sp[j] = tmp;
        // }

        // for (String t : sp) {

        // System.out.print(t);
        // }
        sc.close();
    }
}
