import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class permutingarr{
    static void permutingArray(java.util.List<Integer> arrayList, int element){
        for(int i = element; i < arrayList.size(); i++){
            java.util.Collections.swap(arrayList, i, element);
            permutingArray(arrayList, element+1);
            java.util.Collections.swap(arrayList,element, i);
        }
        if (element == arrayList.size() -1){
            System.out.println(java.util.Arrays.toString(arrayList.toArray()));
        }
    }
    public static void main(String[] args){
        permutingarr.permutingArray(java.util.Arrays.asList(4,5,6), 2);
    }
}