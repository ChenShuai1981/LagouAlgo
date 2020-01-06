package lesson7;

/**
 * 不定长边界问题：
 * 给定日志文件数组
 * [2019-01-12,2019-01-13,...,2019-05-22,null,null,...,null]
 * 统计非null的日志个数
 * 思路：
 * 即查找到第一个右边元素为null的日志元素下标
 */
public class SearchLogs {
    public static void main(String[] args) {
        Integer[] nums = {5,7,7,8,8,10,null,null,null};
        int firstNullIdx = firstNullIdx(nums, 0, nums.length-1);
        int numOfLogs = 0;
        if (firstNullIdx == -1) {
            numOfLogs = nums.length;
        } else {
            numOfLogs = firstNullIdx;
        }
        System.out.println(String.format("numOfLogs: %d", numOfLogs));
    }

    private static int firstNullIdx(Integer[] nums, int low, int high) {
        if (low > high) {
            return nums.length;
        }

        int middle = low + (high - low) / 2;

        if (nums[middle] == null) {
            if (middle == 0 || nums[middle - 1] != null) {
                return middle;
            } else {
                return firstNullIdx(nums, low, middle - 1);
            }
        } else {
            return firstNullIdx(nums, middle + 1, high);
        }
    }
}
