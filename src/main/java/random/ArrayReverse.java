package random;

import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/17/17.
 */
public class ArrayReverse {


    public static void reverseArray(Object data[]) {
        int mid = data.length / 2;
        Object temp;
        System.out.println("mid=" + mid + " data[mid]=" + data[mid]);
        System.out.println(Arrays.toString(data));
        for (int i = 0, j = data.length - 1; i < mid && j > mid; i++, j--) {
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        System.out.println(Arrays.toString(data));
    }


    public static void rotateArray(int[] arr, int d, int n) {
        System.out.println(Arrays.toString(arr)+ " d=" + d + " n=" + n);
        int [] temp = new int[d];
        for(int i=0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int j=0, k=d; k<n; j++, k++) {
            arr[j] = arr[k];
        }

        for (int x = n-d, i=0; x < n; x++, i++) {
            arr[x] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Object[] data = {1, 2, 3, 4, 5, 6};
//        ArrayReverse.reverseArray(data);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2, n = 7;
        ArrayReverse.rotateArray(arr, d, n);
    }
}
