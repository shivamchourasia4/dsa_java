import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * actvtyslcn
 */
public class actvtyslcn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> tr = new TreeMap<>();
        while(n-->0)
        {
            int s = sc.nextInt();
            int f = sc.nextInt();
            tr.put(f, s);
        }
        System.out.println("__________________");
        Set<Map.Entry<Integer,Integer>> srt = tr.entrySet();
        int i = tr.firstKey();
        int cntr=0;
        for(Map.Entry<Integer,Integer> me : srt){
            if(cntr==0){
                System.out.print(me.getValue()+": ");
                System.out.println(me.getKey());
                i=me.getKey();
                cntr++;
            }
            else if(me.getValue()>=i)
            {
                System.out.print(me.getValue()+": ");
                System.out.println(me.getKey());
                i=me.getKey();
            }
        }
        sc.close();
    }
}

//---Alternate Code Using ArrayList!
/*import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
  
public class ActivitySelectionProblem {  
  
    private static int arr[][] = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8},  
            {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}};  
  
    private static List<Activity> nonConflicting(List<Activity> activities) {  
  
        // Non conflicting activities  
        List<Activity> nonConf = new ArrayList<>();  
  
        // Sort activities in increasing order of ending time  
        Collections.sort(activities, (o1, o2) -> o1.getEnd() - o2.getEnd());  
  
        // add first element to it  
        nonConf.add(activities.get(0));  
        int k = 0;  
  
        // start from second element  
        for (int i = 1; i < activities.size(); i++) {  
            if (activities.get(i).getStart() >= activities.get(k).getEnd()) {  
                nonConf.add(activities.get(i));  
                k = i;  
            }  
        }  
        return nonConf;  
    }  
  
    public static void main(String[] args) {  
  
        List<Activity> activities = new ArrayList<>();  
        for (int i = 0; i < arr.length; i++)  
            activities.add(new Activity(arr[i][0], arr[i][1]));  
  
        System.out.println("Activities: ");  
        activities.stream().forEach(System.out::print);  
  
        System.out.println();  
        System.out.println("Non conflicting Activities: ");  
        nonConflicting(activities).stream().forEach(System.out::print);  
    }  
}  
  
class Activity {  
    private int start;  
    private int end;  
    public Activity(int start, int end) {  
        super();  
        this.start = start;  
        this.end = end;  
    }  
    public int getStart() {  
        return start;  
    }  
    public void setStart(int start) {  
        this.start = start;  
    }  
    public int getEnd() {  
        return end;  
    }  
    public void setEnd(int end) {  
        this.end = end;  
    }  
    @Override  
    public String toString() {  
        return "[" + start + "," + end + "]";  
    }  */