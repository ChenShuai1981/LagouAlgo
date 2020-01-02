package lesson1.stack;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Stack;

/**
 * 示例：给定一个数组 T 代表了未来几天里每天的温度值，要求返回一个新的数组 D，D 中的每个元素表示需要经过多少天才能等来温度的升高。
 *
 * 给定 T：[23, 24, 25, 21, 19, 22, 26, 23]
 *
 * 返回 D:  [  1,   1,   4,   2,   1,   1,   0,   0]
 *
 * 该方法只需要对数组进行一次遍历，每个元素最多被压入和弹出堆栈一次，算法复杂度是 O(n)。
 *
 */
public class Temporature {

    public int[] daysAfterUp(int[] temps) {
        int[] result = new int[temps.length];
        Stack<TempData> stack = new Stack();
        for (int i=0; i<temps.length; i++) {
            TempData tempData = new TempData(i, temps[i]);
            if (stack.isEmpty()) {
                stack.push(tempData);
            } else {
                TempData peek = null;
                while(!stack.isEmpty() && (peek = stack.peek()) != null && peek.temp < tempData.temp) {
                    result[peek.index] = tempData.index - peek.index;
                    stack.pop();
                }
                stack.push(tempData);
            }
        }
        // 余下的元素结果都为0
        while (!stack.isEmpty()) {
            TempData peek = stack.pop();
            result[peek.index] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Temporature temporature = new Temporature();
        int[] temps = {23, 24, 25, 21, 19, 22, 26, 23};
        System.out.println(Arrays.toString(temps));
        System.out.println("************************************");
        int[] daysAfterUp = temporature.daysAfterUp(temps);
        System.out.println(Arrays.toString(daysAfterUp));
    }

    @Data
    @AllArgsConstructor
    static class TempData {
        private int index;
        private int temp;
    }

}
