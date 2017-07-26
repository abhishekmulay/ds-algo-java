package random;

import datastructures.DoublyLinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */

//    Merge two sorted linked lists : http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
//
//    Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, and merges the two together into one list which is in increasing order. SortedMerge() should return the new list. The new list should be made by splicing
//    together the nodes of the first two lists.
//
//    For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
//
//    There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during processing either ‘a’ or ‘b’ may run out first, and finally there’s the problem of starting the result list empty, and building it up while going through ‘a’ and ‘b’.

public class MergeLinkedList {

       public List sortedMerge(List<Integer> list1, List<Integer> list2) {
        System.out.println("Merging: " + list1 + " and " + list2);
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("One or more parameters are invalid.");
        }
        if (list1.size() == 0) {
            return list2;
        }
        if (list2.size() == 0) {
            return list1;
        }

        List<Integer> result = new LinkedList<Integer>();
        int i = 0, j = 0, k =0;

        while (i < list1.size() && j < list2.size()) {
            int item1 = list1.get(i);
            int item2 = list2.get(j);

            if (item1 <= item2) {
                result.add(item1);
                i++;
            } else {
                result.add(item2);
                j++;
            }
            k++;
        }

        if (i < list1.size()) {
            while (i < list1.size()) {
                result.add(list1.get(i));
                i++;
            }
        }
        else if (j < list2.size()) {
            while (j < list2.size()) {
                result.add(list2.get(j));
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MergeLinkedList mergeLinkedList = new MergeLinkedList();

        List<Integer> list1 =  new LinkedList<Integer>();
        List<Integer> list2 =  new LinkedList<Integer>();

        list1.add(5);
        list1.add(10);
        list1.add(15);

        list2.add(2);
        list2.add(3);
        list2.add(20);

        List list = mergeLinkedList.sortedMerge(list1, list2);
        System.out.println(list);
    }
}
