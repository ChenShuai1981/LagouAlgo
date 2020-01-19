package lesson9;

import java.util.*;

/**
 * 1+2+10
 *
 * + 1 + 2 - 10
 *
 * sign = +
 * num = 1 => 0
 * sum = 0 => 1
 *
 * sign = + => -
 * num = 2 => 0
 * sum = 1 + 2 => 3
 *
 *
 */
public class BasicCalculator {

    public static void main(String[] args) {
        String expr = "(1+2)*10 - 5*(8-6)";
        int result = calculate(expr);
        System.out.println(result);
    }

    public static int calculate(String expr) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : expr.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        // 以便最后一个数字能够压入栈
        ((LinkedList<Character>) queue).add('+');

        return recurCal(queue);
    }

    public static int recurCal(Queue<Character> queue) {
        char sign = '+';
        int num = 0;

        Stack<Integer> stack = new Stack();

        while(!queue.isEmpty()) {
            // 从队列头取出元素
            char c = queue.poll();

            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = recurCal(queue);
            } else {
                // 根据符号判断如何压栈
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;

                if (c == ')') {
                    break;
                }
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
