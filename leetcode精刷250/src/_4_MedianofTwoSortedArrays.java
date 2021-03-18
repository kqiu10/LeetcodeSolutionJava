package src; /**
 * Date: 11/2/20
 * Question Description
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

 Follow up: The overall run time complexity should be O(log (m+n)).
 Example 1:
 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.
 Example 2:
 Input: nums1 = [1,2], nums2 = [3,4]
 Output: 2.50000
 Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 Example 3:
 Input: nums1 = [0,0], nums2 = [0,0]
 Output: 0.00000
 Example 4:
 Input: nums1 = [], nums2 = [1]
 Output: 1.00000
 Example 5:
 Input: nums1 = [2], nums2 = []
 Output: 2.00000
 */

/**
 * Description: TODO
 * Time complexity:O(log(min(m, n)));
 * Space complexity: O(1);

 */
public class _4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        int len = nums1.length + nums2.length;
        int res = 0;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = cut1 == 0? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    L1 = Math.max(L1, L2);
                    R1 = Math.min(R1, R2);
                    return (R1 - L1) / 2 + L1;
                } else {
                    R1 = Math.min(R1, R2);
                    return R1;
                }
            }
        }
        return -1;
    }
}
