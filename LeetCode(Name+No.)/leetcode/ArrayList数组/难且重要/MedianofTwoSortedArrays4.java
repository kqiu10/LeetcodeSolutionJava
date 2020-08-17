package 数组.难且重要;
/**
 * Package Name : 数组.难且重要;
 * File name : MedianofTwoSortedArrays4;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(log(min(m,n));
 * Space complexity: O(1);
 * Description:
 * index 0 1 2 3 4 5
 *        L1 R1
 * num1: 3 5 | 8 9        cut1: 左有几个元素
 *           L2 R2
 * num2: 1 2 7 | 10 11 12  cut2: 左有几个元素
 *
 * num3: 1 2 3 5 7 | 8 9 10 11 12
 *
 * 求median就是求num1和num2的cut1和cut2而cut2可由cut1求得，所以只需求cut1.
 * num3 -> num1 + num2 -> num1
 *
 * Limitation：
 * L1 <= R2；
 * L2 <= R1;
 *
 * L1 > R2  cutR = cut1 - 1;
 * L2 > R1  cutL = cut1 + 1;
 */

public class MedianofTwoSortedArrays4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int cut1 = 0, cut2 = 0;
        int cutL = 0, cutR = nums1.length;
        int len = nums1.length + nums2.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) cutR = cut1 - 1;
            else if (L2 > R1) cutL = cut1 + 1;
            else {
                if (len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 > R2 ? R2 : R1;
                    return (R1 - L1) / 2 + L1;
                } else {
                    return R1 > R2 ? R2 : R1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
