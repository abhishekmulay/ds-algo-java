package random;

import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/18/17.
 */

//
//  Search an element in a sorted and rotated array
//  An element in a sorted array can be found in O(log n) time via binary search.
//  But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
// So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
// Devise a way to find an element in the rotated array in O(log n) time.

public class FindInSortedPivotedArray {

    public static int mergeFind(int [] arr, int start, int end, int key) {
        System.out.println("Arr: " + Arrays.toString(arr) + " start=" + start + " end=" + end);

        if (start == end) {
            return arr[start] == key ? start : -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            System.out.println("Found at " + mid + " found at mid");
            return mid;
        }

        int foundInLeft = mergeFind(arr, start, mid, key);
        int foundInRight = mergeFind(arr, mid +1, end, key);

        if (foundInLeft > -1) {
            return foundInLeft;
        } else {
            return foundInRight;
        }
    }

    public static void main(String[] args) {
//        int [] arr = {5, 6 ,7, 8, 9, 10, 1, 2, 3};
        int [] arr = {30, 40, 50, 10, 20};
        int key = 3;
        int foundAt = FindInSortedPivotedArray.mergeFind(arr, 0, arr.length-1, key);
        System.out.println("FoundAt = " + foundAt);
    }
}
