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

    private Number eval(String string) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1; // 正负号 (1, -1)
        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                number = number*10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if(number != 0) {
            result += sign * number;
        }
        return result;
    }
}
