package random;

import java.util.*;

/**
 * Created by Abhishek Mulay on 5/17/17.
 */

//    Sort elements by frequency | Set 1
//
//    Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then
//    print the one which came first.
//
//    Examples:
//
//    Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
//    Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
//
//    Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
//    Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}

public class SortByFrequency {

    public static  void sort(int [] arr) {
        System.out.println("Sorting " + arr);
        Map<Integer, Integer> countMap = new TreeMap<Integer, Integer>();
        for (int i : arr) {
            if (countMap.get(i) != null) {
                int frequency = countMap.get(i);
                countMap.put(i, frequency + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        System.out.println(countMap.toString());

        List<Integer> sorted = new ArrayList<Integer>();
        for (int key : countMap.keySet()) {
            sorted.add(key);
        }

        Collections.sort(sorted);
        List<Integer> result = new ArrayList<Integer>();
        for (int i : sorted) {
            int frquency = countMap.get(i);
            while (frquency > 0 ) {
                result.add(i);
                frquency -= 1;
            }
        }

        System.out.println("result = " + result);

    }
    public static void main(String[] args) {
        int [] arr = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999};
        SortByFrequency.sort(arr);
    }
}
