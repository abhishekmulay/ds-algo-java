package ctci;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */
public class ArraysAndStrings {
    public static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int size = chars.length;

        char previous, current, next;
        for (int index = 1; index < size - 1; index++) {
            previous = chars[index - 1];
            current = chars[index];
            next = chars[index + 1];

            boolean dupsFound = previous == current || current == next;
            if (dupsFound)
                return false;
        }
        return true;
    }


    public static boolean isOneAway(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        if (Math.abs(length1 - length2) != 1)
            return false;

        if (length1 > length2)
            return charDiff(str1, str2) < 2;
        else
            return charDiff(str2, str1) < 2;
    }

    private static int charDiff(String big, String small) {
        boolean [] codes = new boolean[128]; //ASCII
        int diffCount = 0;
        int size = big.length();

        String positions = "";
        for (int index=0; index < size; index++) {
            char ch = big.charAt(index);
            int pos = (int) ch;
            positions += "\t" + ch + ":" + pos;
            codes[pos] = true;
        }

        System.out.println(positions);

        String output = "";
        for (char ch : small.toCharArray()) {
            int pos = (int) ch;
            output += "\t" + ch + ":" + pos;
            if (!codes[pos])
                diffCount +=1;
        }
        System.out.println(output);
        return diffCount;
    }

    public static void main(String[] args) {
        String str = "Abhishek";
        String b = "Sushant";
//        System.out.println(ArraysAndStrings.isUnique(str));
//        System.out.println(ArraysAndStrings.isUnique(b));

//        System.out.println(isOneAway("pale", "ple"));
        System.out.println("Should be false = " + isOneAway("pale", "bae"));
    }
}
