package algorithms;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/13/17.
 */
public class MergeSort {

    public static int [] sort(int [] arr) {
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void mergeSort(int [] arr, int start, int end) {
        System.out.println("[mergeSort] start=" + start + " end=" + end);
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end) {
        System.out.println("\t[merge] start=" + start + " mid=" + mid + " end=" + end);

        int i = start, j = mid, k=0;
        int [] temp = new int[(end-start)+1];
        while (i < mid && j <= end) {
            int leftNum = arr[i];
            int rightNum = arr[j];

            if (leftNum <= rightNum) {
                temp[k] = leftNum;
                i++;
            } else {
                temp[k] = rightNum;
                j++;
            }
            k++;
        }

        boolean numRemainingInLeft = i < mid;
        boolean numLeftInRight = j < end;

        if (numRemainingInLeft) {
            while (i < mid) {
                temp[k] = arr[i];
                i++;
                k++;
            }
        } else if (numLeftInRight) {
            while (j <= end) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        System.out.println("Copying temp=" + Arrays.toString(temp) + "\t\t arr=" + Arrays.toString(arr));
        int counter = 0;
        for (int index =start; index <= end ; index++) {
            arr[index] = temp[counter];
            counter += 1;
        }
    }

    public static void main(String[] args) {
        int [] arr = {40, 70, 10, 30, 20, 50, 100, 60, 90, 80};
        System.out.println("Sorting: " + Arrays.toString(arr));
        int[] sorted = MergeSort.sort(arr);
        System.out.println("Sorted " + Arrays.toString(sorted));

//        int test [] = {40, 70, 10, 20, 30, 60};
//        System.out.println(Arrays.toString(test));
//        merge(test, 0, 2, 5);
//        System.out.println(Arrays.toString(test));
    }

}
