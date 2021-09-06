import java.io.*;

public class filehandling {
    public static void main(String[] args) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("op.txt"));

        br.write("3");

        System.out.println("Wrote Success!");

        br.close();

        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        /*
         * 
         * To read multiple lines.
         * 
         * String s; while ((s = br.readLine()) != null) { System.out.println(s); }
         */

        // System.out.println(br.readLine());

        br.close();

    }
}
