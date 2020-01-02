package lesson1.string;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        String test = "algorithm";
        System.out.println(test);
        System.out.println("**************");
        System.out.println(reverseString(test));
    }

    // algorithm
    // 012345678

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int mid = chars.length / 2;
        if (chars.length % 2 == 1) {
            mid = mid + 1;
        }

        for (int i=0,j=chars.length-1; i<mid-1;) {
            swap(chars, i++, j--);
        }

        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
