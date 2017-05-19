package random;

/**
 * Created by Abhishek Mulay on 5/17/17.
 */


//    Maximum sum such that no two elements are adjacent
//    Given an array of positive numbers, find the maximum sum of a subsequence with the constraint
//    that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13
//    (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most
//    efficient way.
//
//    Examples :
//
//    Input : arr[] = {5, 5, 10, 100, 10, 5}
//    Output : 110
//
//    Input : arr[] = {1, 2, 3}
//    Output : 4
//
//    Input : arr[] = {1, 20, 3}
//    Output : 20

public class MaxiumSumSubarray {

    public static int maxSum(int [] arr) {
        int max = -9999999;
        for (int i=0; i< arr.length; i ++) {
            int sum = 0;
            for (int j=i; j < arr.length; j+=2) {
                sum += arr[j];
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int data [] = {5, 5, 10, 100, 10, 5};
        int test [] = {-5, 3, 4 ,-100, -10, 20, -200};

        int result = maxSum(data);
        int result1 = maxSum(test);

        System.out.println("Result = " + result1);
    }

//    are adjacent */
//    int FindMaxSum(int arr[], int n)
//    {
//        int incl = arr[0];
//        int excl = 0;
//        int excl_new;
//        int i;
//
//        for (i = 1; i < n; i++)
//        {
//            /* current max excluding i */
//            excl_new = (incl > excl) ? incl : excl;
//
//            /* current max including i */
//            incl = excl + arr[i];
//            excl = excl_new;
//        }
//
//        /* return max of incl and excl */
//        return ((incl > excl) ? incl : excl);
//    }
//
//    // Driver program to test above functions
//    public static void main(String[] args)
//    {
//        MaxiumSumSubarray sum = new MaxiumSumSubarray();
//        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
//        int test [] = {100, 1, 2, 100};
//        int test1 [] = {-5, 3, 4 ,-100, -10, 20, -200};
//        System.out.println(sum.FindMaxSum(arr, arr.length));
//        System.out.println(sum.FindMaxSum(test1, test1.length));
//    }
}
