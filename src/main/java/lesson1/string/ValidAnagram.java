package lesson1.string;

/**
 * LeetCode 第 242 题：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词
 * 假设两个字符串只包含小写字母
 *
 * 示例 1
 *
 * 输入: s = "anagram", t = "nagaram"
 *
 * 输出: true
 *
 *
 *
 * 示例 2
 *
 * 输入: s = "rat", t = "car"
 *
 * 输出: false
 *
 * 字母异位词，也就是两个字符串中的相同字符的数量要对应相等
 */
public class ValidAnagram {
    public static void main(String[] args) throws Exception {
//        String str1 = "anagram";
//        String str2 = "nagaram";

        String str1 = "rat";
        String str2 = "car";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println("**************");
        System.out.println(validAnagram(str1, str2));
    }

    public static boolean validAnagram(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str1.toCharArray();
        int[] counts = new int[26];
        for (char c : chars1) {
            counts[c - 'a']++;
        }
        for (char c : chars2) {
            counts[c - 'a']--;
        }

        boolean flag = true;
        for (int count : counts) {
            if (count != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
