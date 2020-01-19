import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        boolean flag = test.isIsomorphic("paper", "title");
        System.out.println(flag);

        int[] nums = {};
        int k = 3;
        int[] max = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(max));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        //使用数组记录两个字符串中的映射，译码
        int[] sToT = new int[128]; //s->t
        int[] tToS = new int[128]; //t->s
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i), charT = t.charAt(i);
            //当前字符是否存在于数组中
            if ((sToT[charS] != 0 && sToT[charS] != charT) || (tToS[charT] != 0 && tToS[charT] != charS)) {
                return false;
            } else {
                sToT[charS] = charT;
                tToS[charT] = charS;
            }

        }
        return true;
    }

    // 输入 nums = [1,3,-1,-3,5,3,6,7] , k = 3
    // 输出 [3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }
}
