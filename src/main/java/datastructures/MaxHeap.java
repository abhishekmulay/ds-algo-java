package datastructures;

import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 7/10/17.
 */
public class MaxHeap {

    private int[] arr = null;

    public MaxHeap(int[] arr) {
        this.arr = arr;
        this.buildMaxHeap();
    }

    public void buildMaxHeap() {
        int numElements = this.arr.length;
        System.out.println("[buildHeap] Building heap of size = [" + numElements + "] from " + Arrays.toString(this.arr));
        for (int i = (numElements / 2 + 1); i >= 0; i--) {
            this.maxHeapify(this.arr, i);
        }
        System.out.println("\n[buildHeap] Created max-heap "+ Arrays.toString(this.arr) + "\n");
    }

    private void maxHeapify(int[] arr, int index) {
//        System.out.println("[maxHeapify] arr[index] = [" + arr[index] + "]\t index =[" + index + "]");
        int currentItem = arr[index];
        int leftIndex = getLeftIndex(index);

        int rightIndex = getRightIndex(index);
        int largest = -1;

        if (leftIndex < this.size() && arr[leftIndex] > currentItem) {
            largest = leftIndex;
        } else {
            largest = index;
        }

        if (rightIndex < this.size() && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            arr[index] = arr[largest];
            maxHeapify(arr, largest);
        }
    }

    public int size() {
        return arr.length;
    }

    public int getMax() {
        return arr[0];
    }

    /////////////////// helper methods ////////////////////////

    private int getParentIndex(final int index) {
        return (int) Math.floor(index / 2);
    }

    private int getLeftIndex(final int index) {
        return 2 * index + 1;
    }

    private int getRightIndex(final int index) {
        return 2 * index + 2;
    }

    ///////////////////// main ///////////////////////////////

    public static void main(String[] args) {
//        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        int [] arr = {40, 70, 10, 30, 20, 50, 100, 60, 90, 80};
        MaxHeap heap = new MaxHeap(arr);
        int max = heap.getMax();
        System.out.println("Max in " + Arrays.toString(arr) + " is max = " + max);
    }


}
