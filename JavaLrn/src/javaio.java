import java.io.*;

//A stream is an abstraction that either produces or consumes data

//using a BufferedReader to read characters from the console
public class javaio {
    public static void main(String[] args) throws IOException{
        //char c;
        String c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.err.println("Enter Char , q to quit.");
        PrintWriter pw = new PrintWriter(System.out,true);
        //reading characters
        do{
            c = br.readLine();
          //  c = (char)br.read(); //reads only int!!
            pw.println(c);
        }while(!c.equals("q"));
        //system.in is line bufered by default


        //system.out is used mostly for debugging and sample programs.. in real world programs, we use PrintWriter stream
    }
}
