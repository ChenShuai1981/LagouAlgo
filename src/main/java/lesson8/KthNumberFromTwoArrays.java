package lesson8;

/**
 * 给定两个数组，找到两个数组合并后的第K个大小的元素
 */
public class KthNumberFromTwoArrays {

    public static void main(String[] args) {
//        int[] nums1 = {2,5,3,1,8,4};
//        int[] nums2 = {9,10,6,11,7};
        int[] nums1 = {1,5,8,6};
        int[] nums2 = {2,3,4,7};
        int k = 6;
        int kth = findKthNumber(nums1, nums2, k);
        System.out.println(String.format("kth: %d", kth));
    }

    public static int findKthNumber(int[] nums1, int[] nums2, int k) {
        return quickSelect(nums1, nums2, 0, nums1.length + nums2.length -1, k);
    }

    private static int quickSelect(int[] nums1, int[] nums2, int low, int high, int k) {
        int pivot = low;

        for (int j=low; j<high; j++) {
            // 这里每次选取最后一个值为基准值
            if (getNum(nums1, nums2, j) <= getNum(nums1, nums2, high)) {
                swap(nums1, nums2, pivot++, j);
            }
        }
        swap(nums1, nums2, pivot, high);

        // count the nums that are > pivot from high
        int count = pivot - low + 1;

        if (count == k) {
            // 恰好是基准值
            return getNum(nums1, nums2, pivot);
        } else if (count > k) {
            // 比基准值小
            return quickSelect(nums1, nums2, low, pivot-1, k);
        } else {
            // 比基准值大
            return quickSelect(nums1, nums2, pivot+1, high, k-count);
        }
    }

    private static int getNum(int[] nums1, int[] nums2, int index) {
        return index < nums1.length ? nums1[index] : nums2[index - nums1.length];
    }

    private static void swap(int[] nums1, int[] nums2, int i, int j) {
        int m = nums1.length;
        if (i < m && j < m) {
            swap(nums1, i, j);
        } else if (i >= m && j >= m) {
            swap(nums2, i-m, j-m);
        } else if (i < m && j >= m) {
            int tmp = nums1[i];
            nums1[i] = nums2[j-m];
            nums2[j-m] = tmp;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
