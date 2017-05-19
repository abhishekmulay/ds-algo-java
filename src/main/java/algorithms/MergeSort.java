package algorithms;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/13/17.
 */
public class MergeSort {


    public int [] mergeSort(int [] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            return merge(arr, start, mid, end);
        }
        return null;
    }

    private int[] merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid, k=0;
        int [] temp = new int[0];

        while (i < mid && j < end) {
            int leftItem = arr[i];
            int rightItem = arr[j];

            if (leftItem >= rightItem) {
                temp[k] = rightItem;
                j++;
            } else {
                temp[k] = leftItem;
                i++;
            }
            k++;
        }

        boolean itemsRemaingInLeft = i < mid;
        boolean itemsRemaingInRight = j < end;

        if (itemsRemaingInLeft) {
            System.arraycopy(temp, i, temp, k, arr.length - i);

        } else if (itemsRemaingInRight) {
            System.arraycopy(temp, j, temp, k, arr.length - i);
        }

        System.arraycopy(temp, start, arr, start, temp.length);
        return arr;
    }


    public int [] sort(int[] arr) {
        int start = 0;
        int end = arr.length;
        return mergeSort(arr, start, end);
    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 0, 4, 7, 3, 2, 2};
        System.out.println("Unsorted: " + Arrays.toString(arr));
        MergeSort sorter = new MergeSort();
        int [] sorted = sorter.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

}
