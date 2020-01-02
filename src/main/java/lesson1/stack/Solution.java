package lesson1.stack;

import java.util.Stack;

public class Solution {

    /**
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     *
     * 左括号必须以正确的顺序闭合。
     *
     * 注意：空字符串可被认为是有效字符串。
     *
     * @param string
     * @return
     */
    public boolean validParentheses(String string) {
        if (string == null || string.trim().equals("")) return true;
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                char peek = stack.peek();
                if (match(peek, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

    private boolean match(char a, char b) {
        boolean b1 = a == '(' && b == ')';
        boolean b2 = a == '[' && b == ']';
        boolean b3 = a == '{' && b == '}';

        return b1 || b2 || b3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = "[{()[({()})]}]";
        System.out.println(string);
        System.out.println("**************");
        boolean validParentheses = solution.validParentheses(string);
        System.out.println(validParentheses);
    }
}
