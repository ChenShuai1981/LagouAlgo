package lesson8;

/**
 * 输出两个数组的中位数
 * 第一个数组个数m，第二个数组个数n
 * m+n奇数个数时，输出 (m+n)/2 + 1
 * m+n偶数个数时，输出 ((m+n)/2 + ((m+n)/2+1))/2
 */
public class MedianArrays {

    public static void main(String[] args) {
        // 1,2,3,4,5,6,7,8
        int[] nums1 = {1,5,8,6};
        int[] nums2 = {2,3,4,7};
        double medianNumber = findMedianNumber(nums1, nums2);
        System.out.println("medianNumber = " + medianNumber);
    }

    private static double findMedianNumber(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m+n) % 2 == 1) {
            // 奇数个数
            int k = (m+n)/2 + 1;
            return KthNumberFromTwoArrays.findKthNumber(nums1, nums2, k);
        } else {
            int k1 = (m+n)/2;
            int k2 = (m+n)/2 + 1;
            int s1 = KthNumberFromTwoArrays.findKthNumber(nums1, nums2, k1);
            int s2 = KthNumberFromTwoArrays.findKthNumber(nums1, nums2, k2);
            return (s1 + s2)*1.0d / 2;
        }
    }
}
