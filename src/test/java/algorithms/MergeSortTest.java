package algorithms;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abhishek Mulay on 5/20/17.
 */
public class MergeSortTest {

    @Test
    public void sort() throws Exception {
        int [] arr = {4, 7, 1, 3, 2, 5, 10, 6, 9, 8};
        int [] sorted = MergeSort.sort(arr);
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals("Array is not sorted in correct order ", expected,sorted);
    }

    @Test
    public void merge() {
        int [] arr = {10, 20, 30, 40, 1, 2, 3, 4};
        int [] expected = {1, 2, 3, 4, 10, 20, 30, 40};
        MergeSort.merge(arr, 0, 4, arr.length);
        Assert.assertArrayEquals("Array is not merged correctly ", expected, arr);
    }

}