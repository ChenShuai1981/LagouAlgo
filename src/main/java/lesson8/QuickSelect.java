package lesson8;

/**
 * 快速选择算法
 * 在无序的数组中寻找第K个大小的元素
 *
 * 时间复杂度是 O(n)
 * 空间复杂度是 O(1)
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {2,5,3,1,8,4,9,10,6,11,7};
        int k = 6;
        int kth = findKthLargest(nums, k);
        System.out.println(String.format("kth: %d", kth));
    }

    private static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    /**
     * 1. 随机从数组中选择一个数作为基准值
     *
     * 2. 将数组排列成两部分：以基准值为分界点，左边的数都小于基准值，右边的数都大于基准值
     *
     * 3. 判断基准值所在位置P
     * 如果p=k，基准值即为所找值，直接返回
     * 如果k<p，基准值过大，搜索范围缩小至基准值左边
     * 如果k>p，基准值过小，搜索范围缩小至基准值右边，此时应寻找第k-p小的数，前p个数已经被淘汰
     *
     * 4. 重复第一步，直到基准值的位置p恰好等于k
     *
     * @param nums
     * @param low
     * @param high
     * @param k
     * @return
     */
    private static int quickSelect(int[] nums, int low, int high, int k) {
        // 基准值所在的序号idx
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are > pivot to the right
        int base = nums[high];
        for (int j=low; j<high; j++) {
            // 这里每次选取最后一个值为基准值
            if (nums[j] <= base) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = pivot - low + 1;

        if (count == k) {
            // 恰好是基准值
            return nums[pivot];
        } else if (count > k) {
            // 比基准值小
            return quickSelect(nums, low, pivot-1, k);
        } else {
            // 比基准值大
            return quickSelect(nums, pivot+1, high, k-count);
        }
    }

    private static void swap(int[] nums, int s, int t) {
        if (s != t) {
            int tmp = nums[s];
            nums[s] = nums[t];
            nums[t] = tmp;
        }
    }

}
