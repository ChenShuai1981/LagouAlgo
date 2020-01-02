package lesson1.stack;

import java.util.Stack;

/**
 * Leetcode 224
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 */
public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String expression = "(1+(4+5+2)-3)+(6+8)";
        Number number = bc.eval(expression);
        System.out.println(number);
    }

    private Number eval(String expression) {
        char[] chars = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

    }
}
