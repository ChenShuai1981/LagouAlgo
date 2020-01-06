package lesson7;

/**
 * LeetCode 34
 *
 * 给定一个按照升序排列的数组nums
 * 和一个目标值target
 * 找出给定目标值在数组中的开始位置和结束位置
 *
 * 算法时间复杂度必须是O(logn)级别
 * 如果数组中不存在目标值，返回[-1, -1]
 *
 * 思路：
 * 求lowerBound
 * nums[middle]=target之后，
 *   判断左边一个数是否小于target或者middle=0表示已经是第一个数了
 *
 * 求upperBound
 * nums[middle]=target之后，
 *   判断右边一个数是否大于target或者middle=nums.length-1表示已经是最后一个数了
 */
public class LongestSubList {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int lowerBound = lowerBound(nums, target, 0, nums.length-1);
        int upperBound = upperBound(nums, target, 0, nums.length-1);
        System.out.println(String.format("[%d, %d]", lowerBound, upperBound));
    }

    public static int lowerBound(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (nums[middle] == target) {
            if (middle == 0 || nums[middle - 1] < target) {
                return middle;
            } else {
                return lowerBound(nums, target, low, middle - 1);
            }
        }

        if (target < nums[middle]) {
            return lowerBound(nums, target, low, middle - 1);
        } else {
            return lowerBound(nums, target, middle + 1, high);
        }
    }

    public static int upperBound(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (nums[middle] == target) {
            if (middle == nums.length - 1 || nums[middle + 1] > target) {
                return middle;
            } else {
                return upperBound(nums, target, middle + 1, high);
            }
        }

        if (target < nums[middle]) {
            return upperBound(nums, target, low, middle - 1);
        } else {
            return upperBound(nums, target, middle + 1, high);
        }
    }
}
