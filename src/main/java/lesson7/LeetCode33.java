package lesson7;

/**
 * 搜索旋转排序数组
 *
 * 题目描述：
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int idx = findInRotatingArray(nums, target,0, nums.length-1);
        System.out.println(idx);
    }

    private static int findInRotatingArray(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        // 判断从哪半部分查找
        if (nums[low] < nums[middle]) {
            // 说明左半部分有序
            if (nums[low] <= target) {
                return binarySearch(nums, target, low, middle - 1);
            } else {
                return binarySearch(nums, target, middle + 1, high);
            }
        } else {
            // 说明右半部分有序
            if (nums[high] >= target) {
                return binarySearch(nums, target, middle + 1, high);
            } else {
                return binarySearch(nums, target, low, middle - 1);
            }
        }
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        if (target < nums[middle]) {
            return binarySearch(nums, target, low, middle - 1);
        } else {
            return binarySearch(nums, target, middle + 1, high);
        }
    }


}
