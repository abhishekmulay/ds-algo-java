package random;

/**
 * Created by Abhishek Mulay on 5/31/17.
 */


// String Compression: Implement a method to perform basic string compression using the counts
// of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would
// not become smaller than the original string, your method should return the original string.
// You can assume the string has only uppercase and lowercase letters (a - z).


public class BasicStringCompression {
    public static String compressString(final String originalString) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = originalString.toCharArray();
        int length = chars.length;
        int count = 1;


        for (int index=1; index< length; index ++) {
            char prev = chars[index-1];
            char current = chars[index];

            if (prev == current) {
                count ++;
            } else {
                buffer.append(prev).append(count);
                count = 1;
            }
        }
        buffer.append(chars[length-1]).append(count);
        return buffer.toString();
    }

    public static void main(String[] args) {
        String actual = compressString("aabcccccaaad");
        System.out.println();
        final String expected = "a2b1c5a3";
        System.out.println("aabcccccaaa");
        System.out.println(actual);
        System.out.println(expected.equals(actual));
    }
}
