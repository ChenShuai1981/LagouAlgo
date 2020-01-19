package lesson7;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 4, 7, 9};
        int target = 7;
        BinarySearch bs = new BinarySearch();
        int idx = bs.find2(nums, target, 0, nums.length-1);
        System.out.println(idx);
    }

    // 递归方法
    int find(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        if (target < nums[middle]) {
            return find(nums, target, low, middle - 1);
        } else {
            return find(nums, target, middle + 1, high);
        }
    }

    // 非递归方法
    int find2(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
