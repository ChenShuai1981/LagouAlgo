package lesson7;

/**
 * 模糊边界问题
 * 从数组中找到第一个大于6的数
 */
public class FuzzyBoundary {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,4,7,9,10};
        int gt = 6;
        int idx = firstGreater(nums, gt,0, nums.length-1);
        System.out.println(idx);
    }

    /**
     * 首先，这个数要大于gt;
     * 其次，左边这个数要小于gt或者上一步中出现的这个数是数组中的第一个数
     *
     * @param nums
     * @param gt
     * @param low
     * @param high
     * @return
     */
    public static int firstGreater(int[] nums, int gt, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (nums[middle] > gt && (middle == 0 || nums[middle-1] < gt)) {
            return middle;
        }

        if (gt < nums[middle]) {
            return firstGreater(nums, gt, low, middle - 1);
        } else {
            return firstGreater(nums, gt, middle + 1, high);
        }
    }
}
