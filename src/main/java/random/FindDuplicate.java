package random;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Abhishek Mulay on 6/1/17.
 */
public class FindDuplicate {


    public static <E> void reverseList(List<E> list) {

    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(1);
        System.out.println("Before reverse: " + list);
        reverseList(list);
    }

}
