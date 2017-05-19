package random;

import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/15/17.
 */
public class WaveLikeArray {

    public static void main(String[] args) {
        int [] data = {5, 0, 4, 2, 3, 1, 10};
        System.out.println("Data " + Arrays.toString(data));
        Arrays.sort(data);

        System.out.println("Sorted :" + Arrays.toString(data));
        int temp;
        for (int index=0; index < data.length-1; index+=2) {
            temp = data[index];
            data[index] = data[index +1];
            data[index+1] = temp;
        }

        System.out.println("Wave array: " + Arrays.toString(data));

    }
}
