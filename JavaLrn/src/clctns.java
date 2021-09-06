
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.ListIterator;
// import java.util.Map;
// import java.util.Set;
// import java.util.Spliterator;
// import java.util.TreeMap;
// import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
     * mycomp implements Comparator<String>
     class mycomp implements Comparator<String> {
        public int compare(String a,String b) {
            return b.compareTo(a);
        }
    }*/
/**
 * TComp implements Comparator,String>
 */
//  class TComp implements Comparator<String> {
//     public int compare(String a,String b){
//         int i,j,k;
//         //Finding index of beginig of last name
//         i = a.lastIndexOf(' ');
//         j = b.lastIndexOf(' ');

//         k = a.substring(i).compareToIgnoreCase(b.substring(j));
//         if(k==0) //last names match , check entire name
//             return a.compareToIgnoreCase(b);
//         else
//             return k;
//     }

// }    
public class clctns {

	public static void main(String[] args) {

		// ArrayList<String> al = new ArrayList<>();
		// al.add("C");
		// al.add("F");
		// al.add("R");
		// al.add("T");
		// System.out.println(al);
		// //Iterating using for each loop
		// for(String h:al){
		// System.out.print(h+" " );
		// }
		// System.out.println();
		// System.out.println("________________");
		// Iterator<String> itr = al.iterator();
		// while(itr.hasNext())
		// {
		// String ele = itr.next();
		// System.out.print(ele+" ");
		// }
		// System.out.println();

		// //Modifying elements being iterated
		// ListIterator<String> litr = al.listIterator();
		// while(litr.hasNext())
		// {
		// String ele = litr.next();
		// litr.set(ele+"+");
		// }
		// itr = al.iterator();//needed to reset to the begining as it points to end of
		// the list!!!
		// while(itr.hasNext())
		// {
		// String ele = itr.next();
		// System.out.print(ele+" ");
		// }
		// System.out.println();
		// //Printing Backwards No need to reset litr as it is pointing to the end of
		// the list itself!
		// while(litr.hasPrevious())
		// {
		// System.out.print(litr.previous()+" ");
		// }

		// //Spliterator--------------- //allows parallel iteration of portion of the
		// sequence
		// ArrayList<Double> vals = new ArrayList<>();
		// vals.add(1.0);
		// vals.add(2.0);
		// vals.add(3.0);
		// vals.add(4.0);
		// vals.add(5.0);

		// //tryAdvance() is used
		// System.out.println("\nVals elements");
		// Spliterator<Double> splitr = vals.spliterator();
		// while(splitr.tryAdvance((n)->System.out.print(n+" ")));
		// System.out.println();
		// //using spliterator for aq roots:
		// splitr = vals.spliterator();
		// while(splitr.tryAdvance((n) ->System.out.print(Math.sqrt(n)+" ")));
		// System.out.println();

		// //Using ForEachRemaining()---
		// splitr = vals.spliterator();
		// splitr.forEachRemaining((n)->System.out.print(n+" "));

		// MAPS-----------
		// Non Iterable (NOT collection as they do not implement the collection
		// interface)
		// Can't obtain an iterator to a map
		// Collection view can be obtained, which allows the use of for loop.
		// To get their collection view, use entrySet() for a set of the elements in
		// map. use keySet() for collection-view of keys and similary values()

		// Map Interface maps unique keys to values, key is used to retrive them

		// Abstract Map
		// Enum Map ===entends Abstract Map to use with enum values
		// Hash Map ===with hash table
		// Tree Map ===with tree
		// WeakHashMap ===weak keys
		// LinkedHashMap === extends HAshMap to allow insertion-order iterations
		// Identity HashMap ===uses reference equality when comparing docs

		// HashMap----------------------------
		// HashMap<String,Double> hm = new HashMap<>();
		// hm.put("A", 3.0);
		// hm.put("B", 4.76);
		// hm.put("C", 67.99);
		// hm.put("D", 44.9);
		// System.out.println(hm);

		// //Getting a set of entries----
		// Set<Map.Entry<String,Double>> set = hm.entrySet();
		// for(Map.Entry<String,Double> me:set){
		// System.out.print(me.getKey()+": ");
		// System.out.println(me.getValue());
		// }
		// System.out.println();
		// hm.put("A", hm.get("A")+1000);
		// System.out.println("chn "+hm.get("A"));

		// //TreeMap -- allwos storing key with values in sorted order
		// //only navigableMap and AbstractMap
		// TreeMap<Integer,Integer> fr = new TreeMap<>(); //TreeSet takes entries in
		// srtd order!
		// fr.put(5,9);
		// fr.put(1, 2);
		// fr.put(3, 4);
		// fr.put(0,6);
		// fr.put(5,7);
		// fr.put(8,9);

		// System.out.println(fr);

		// Set<Map.Entry<Integer,Integer>> srt = fr.entrySet();
		// for(Map.Entry<Integer,Integer> me:srt){
		// System.out.print(me.getKey()+": ");
		// System.out.println(me.getValue());
		// }
		// fr.put(0, fr.get(0)+700);
		// System.out.println("cng :"+fr.get(0));

		// Linked Hash Map
		// Maintains a Linked List of the entries in the map in the order in which they
		// were inserted

		// COMPARATOR------------------------------------------------
		// SPECIFY COMPARATOR WHEN WE WANT TO ORDER OR COMPARE ELEMENTS OUR WAY
		// TreeSet<String> ts = new TreeSet<String>(new mycomp()); //invoking mycomp
		// reverses the comparison

		// No need of creating the mycomp class instead use lambda exp
		// Comparator<String> mc = (a,b)->a.compareTo(b);
		// TreeSet<String> ts = new TreeSet<>(mc.reversed());

		// my .reversed not working
		// TreeSet<String> ts = new TreeSet<>((a,b)->b.compareTo(a));
		// ts.add("A");
		// ts.add("G");
		// ts.add("R");
		// ts.add("D");

		// System.out.println(ts);

		// TreeMap<String,Integer> tm = new TreeMap<String,Integer>(new TComp());
		// tm.put("John Snow", 3);
		// tm.put("Sam Smith", 14);
		// tm.put("Jane Baker", 33 );
		// tm.put("Tod Hall", 32);
		// tm.put("Ralph Smith", 447);
		// System.out.println(tm);
		// Set<Map.Entry<String,Integer>> sm = tm.entrySet();

		// for(Map.Entry<String,Integer> me:sm){
		// System.out.print(me.getKey()+" : ");
		// System.out.println(me.getKey());
		// }
		// tm.put("Jane Baker", tm.get("Jane Baker")+100);
		// System.out.println(tm.get("Jane Baker"));

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(27);
		ll.add(3);
		ll.add(34);
		ll.add(16);

		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(ll, r);
		System.out.println(ll);
		Collections.shuffle(ll);
		System.out.println(Collections.max(ll));
		System.out.println(Collections.min(ll));
	}
}
