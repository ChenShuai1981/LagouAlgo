import java.util.HashMap;
import java.util.Map;

public class SolutionLongest {

//    /**
//     * 0,1
//     * 1,0
//     * 0,-1
//     * -1,0
//     */
//    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下上左
//
    public static void main(String[] args) {
        SolutionLongest k = new SolutionLongest();
//        int[][] nums = {{3,4,5}, {3,2,6}, {2,2,1}};
//        int max = k.longestIncreasingPath(nums);
//        System.out.println(max);

        int[] matrix = {4,5,6,7,8,0,1,2};
        int target = 1;
        System.out.print(k.search(matrix, target));
    }
//
//    public int longestIncreasingPath(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        int[][] cache = new int[m][n];
//        int res = 1;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                res = Math.max(res, dfs(matrix, i, j, cache));
//            }
//        }
//        return res;
//    }
//
//    /**
//     * [
//     *   [3,4,5],
//     *   [3,2,6],
//     *   [2,2,1]
//     * ]
//     */
//    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
//        if (cache[i][j] != 0) {
//            return cache[i][j];
//        }
//        int max = 1;
//        int m = matrix.length, n = matrix[0].length;
//        for (int[] dir : dirs) {
//            int x = i + dir[0], y = j + dir[1];
//            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] > matrix[x][y]) {
//                max = Math.max(max, 1 + dfs(matrix, x, y, cache));
//            }
//        }
//        cache[i][j] = max;
//        return max;
//    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, loop(matrix, Integer.MIN_VALUE, dp, i, j)); //从每个节点开始搜索
            }
        }
        return max;
    }
    /**
     * 记忆化搜索
     * @param mat  数据矩阵
     * @param pre  路径中的前一个结点数字
     * @param dp   保存从每个结点开始搜索的最长升序序列的长度
     * @param i    当前位置
     * @param j    当前位置
     * @return
     */
    private int loop(int[][] mat, int pre, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] <= pre) {  //停止搜索条件
            return 0;
        }
        if (dp[i][j] != 0) {  //如果有数据，直接返回
            return dp[i][j];
        }
        int max = 0;  //进行搜索
        max = Math.max(max, loop(mat, mat[i][j], dp, i - 1, j)); // 左
        max = Math.max(max, loop(mat, mat[i][j], dp, i + 1, j)); // 右
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j - 1)); // 上
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j + 1)); // 下
        dp[i][j] = max + 1;
        return dp[i][j];
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}