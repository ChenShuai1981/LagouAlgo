package lesson8;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串长度
 *
 * 慢指针i, 快指针j
 *
 *     i
 * d e a b c a e
 *           j
 *
 * 时间复杂度是 O(n)
 * 空间复杂度是 O(n)
 */
public class LongestSubString {
    public static void main(String[] args) {
        String str = "deabcae";
        int lengthOfLongestSubstring = lengthOfLongestSubstring(str);
        System.out.println(String.format("lengthOfLongestSubstring: %d", lengthOfLongestSubstring));
    }

    private static int lengthOfLongestSubstring(String s) {
        // 哈希表
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i=0,j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                // d e a [b] c a e
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            max = Math.max(max, j-i+1);
        }

        return max;
    }
}
