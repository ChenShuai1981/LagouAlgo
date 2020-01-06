package lesson1.string;

public class Solution {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: "abcabcbb"
     * 输出: 3
     *
     * 输入: "bbbbb"
     * 输出: 1
     *
     * 输入: "pwwkew"
     * 输出: 3
     *
     * @param s
     * @return
     *
     * 另一种解法见 LongestSubString
     */
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];

        int res = 0, left = 0;

        // abcabcbb
        // 123
        // left=0; res=3
        // left=Max(0,1)=1; res=Max(3,3-1+1)=3
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left = Math.max(left, m[c]);
            res = Math.max(res, i - left + 1);
            m[c] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = "pwwkew";
        System.out.println(string);
        System.out.println("**************");
        int longestSubstringLength = solution.lengthOfLongestSubstring(string);
        System.out.println(longestSubstringLength);
    }
}
