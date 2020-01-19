package lesson10;

public class RegExpr {

    public static void main(String[] args) {
//        String s = "ab";
//        String p = ".*";

        String s = "aab";
        String p = "c*a*b";

//        String s = "mississippi";
//        String p = "mis*is*p*.";

//        String s = "football";
//        String p = "fo*t.al*";

        boolean isMatch = isMatch(s, p);
        System.out.println(isMatch);
    }

    private static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatchForward(s, 0, p, 0);
//        return isMatchBackward(s, s.length(), p, p.length());
    }

    // 从后往前递归
    private static boolean isMatchBackward(String s, int i, String p, int j) {
        if (j==0) return i==0;

        if(i == 0) {
            return j>1 && p.charAt(j-1) == '*' && isMatchBackward(s, i, p, j-2);
        }

        if(p.charAt(j-1)!='*') {
            return isMatch(s.charAt(i-1), p.charAt(j-1)) && isMatchBackward(s, i-1, p, j-1);
        }

        return isMatchBackward(s, i, p, j-2) ||
                isMatchBackward(s, i-1, p, j) && isMatch(s.charAt(i-1), p.charAt(j-2));
    }

    static boolean isMatch(char a, char b) {
        return a == b || b == '.';
    }

    // 从前往后递归
    private static boolean isMatchForward(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        if (j==n) {
            return i==m;
        }

        if (j == n-1 || p.charAt(j+1) != '*') { // 下一个字符不是*号
            return (i < m)
                    && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) // 字符相同或者p包含.
                    && isMatchForward(s, i+1, p, j+1); // 继续比较下一个字符
        }

        if (j < n-1 && p.charAt(j+1) == '*') { // 下一个字符是*号
            while((i < m) && (
                    p.charAt(j) == '.'
                        || s.charAt(i) == p.charAt(j)
//                        || (s.charAt(i) != p.charAt(j) && s.charAt(i) == p.charAt(j+2))  // TODO: 疑似漏了这一个或条件!?
            )) {
                // 回溯，尝试匹配空字符、一个前字符、两个前字符 ...
                if (isMatchForward(s, i, p, j+2)) {
                    return true;
                }
                i++;
            }
        }

        return isMatchForward(s, i, p, j+2);
    }


}
