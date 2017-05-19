package random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhishek Mulay on 5/18/17.
 */
public class PairSum {

    public static void findPairWithSum(int[] arr, int targetSum) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int complement = targetSum - num;
            hash.put(num, complement);
        }

        for (int key : hash.keySet()) {
            int complement = hash.get(key);
            if (hash.containsKey(complement)) {
                System.out.println("Found pair: (" + key +", "+ complement +")");
                break;
            }
        }

    }

    public static void main(String[] args) {
        int [] arr = {1, 4, 45, 6, 10, -8};
        int targetSum = 16;
        findPairWithSum(arr, targetSum);

        System.out.println(2^3);
    }
}
