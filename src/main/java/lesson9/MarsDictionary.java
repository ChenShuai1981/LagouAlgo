package lesson9;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 269
 * 火星字典
 *
 * 输入
 * wrt
 * wrf
 * er
 * ett
 * rftt
 *
 * 输出 wertf
 *
 * 输入
 * z
 * x
 * z
 *
 * 输出
 * 空字符串 表示非法
 *
 * 输入
 * z
 * x
 *
 * 输出 zx
 */
public class MarsDictionary {
    public static void main(String[] args) {
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"z", "x", "z"};
        String[] words = {"z", "x", "x"};
        String charOrders = charOrder(words);
        System.out.println(charOrders);
    }

    private static String charOrder(String[] words) {
        char[][] chars = new char[words.length][];
        int maxLength = 0;
        for (int i=0; i<words.length; i++) {
            chars[i] = words[i].toCharArray();
            maxLength = Math.max(maxLength, chars[i].length);
        }

        List<Character> charOrders = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            List<Character> iterChars = new ArrayList<>();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j].length > i) {
                    // 有字符
                    Character c = chars[j][i];
                    if (!iterChars.contains(c)) {
                        iterChars.add(c);
                    } else if (chars[j][i] != chars[j-1][i]) {
                        return ""; // 表示非法
                    }
                    if (!charOrders.contains(c)) {
                        charOrders.add(c);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : charOrders) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
