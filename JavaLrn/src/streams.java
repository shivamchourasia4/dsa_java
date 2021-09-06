import java.util.*;
import java.util.stream.*;

public class streams {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(18);
        al.add(10);
        al.add(24);
        al.add(17);
        al.add(7);

        System.out.println("Original al: " + al);

        // obtaining a stream to al
        Stream<Integer> ms = al.stream();
        // System.out.println(ms.getClass().getSimpleName());
        int md;
        Optional<Integer> minval = ms.min(Integer::compare);
        if (minval.isPresent())
            System.out.println("min val: " + minval.get());
        md = minval.get();
        System.out.println(md);
        // new stream must be made becoz prev was consumed!!
        ms = al.stream();
        Optional<Integer> maxval = ms.max(Integer::compare);
        if (maxval.isPresent())
            System.out.println("max val :" + maxval.get());

        // Sorting the stream
        ms = al.stream().sorted();
        System.out.println("Sorted Stream: ");
        ms.forEach((n) -> System.out.print(n + " "));

        // filtering to show only odd value
        ms = al.stream().sorted().filter((n) -> (n % 2) != 0);
        System.out.println("filterd odd values :");
        ms.forEach((n) -> System.out.print(n + " "));

        // applying two filters at once
        ms = al.stream().sorted().filter((n) -> (n % 2) != 0).filter((n) -> n > 5);

        System.out.println("\nodd values greater than 5: ");
        ms.forEach((n) -> System.out.print(n + " "));

        Optional<Integer> reduced_val = al.stream().reduce((a, b) -> a * b);
        System.out.println("Reduce demo");
        // type is optional
        System.out.println(reduced_val.get() + " " + reduced_val.getClass().getName());
        // can be converted into int like this
        Integer ans = al.stream().reduce(1, (a, b) -> a * b);
        System.out.println(ans);
        // here 1 is the identity value which is 1 for multiplicatio , 0 for add ....

    }
}
