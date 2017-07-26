package random;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Abhishek Mulay on 6/1/17.
 */
public class RemoveDuplicateFromList {

    public static <E> List<E> removeDuplicates(List<E> list) {
        if (list.size() <= 1) {
            return list;
        } else {
            E first = list.remove(0);
            removeDuplicates(list).add(first);
            return list;
        }
    }

    static int saveThePrisoner(int n, int m, int s) {
        // one candy
        if (m <= 1) {
            return m;
        }
        // one prisoner
        if (n <= 1) {
            return n;
        }

        // Complete this function
        int i = s-1;
        int candyCounter = 0;
        while (candyCounter < m) {
            if (i == n) {
                i = 1; // reset
            }else {
                i++;
            }
            candyCounter += 1;
        }
        return i;
    }


    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(4);
//        list.add(1);
//        list.add(5);
//        list.add(3);
//
//        List<Integer> filtered = removeDuplicates(list);
//        System.out.println(filtered);

        System.out.println(saveThePrisoner(5, 2, 1)); // 2
        System.out.println(saveThePrisoner(5, 9, 4)); // 2
        System.out.println(saveThePrisoner(5, 10, 2)); // 1
        System.out.println(saveThePrisoner(5, 9, 3)); // 3
//        352926151 380324688 94730870
        System.out.println(saveThePrisoner(352926151, 380324688, 94730870)); // 122129406
//#content :not(.mw-editsection) > a:not([href^="#"])
//
    }
}
