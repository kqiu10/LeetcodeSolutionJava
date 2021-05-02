package com.antra;
/**
 * Date: 4/25/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e1 = m - 1;
        int e2 = n - 1;
        int end = m + n - 1;
        while (e1 >= 0 || e2 >= 0) {
            while (e1 >= 0 && e2 >= 0) {
                nums1[end--] = nums1[e1] > nums2[e2] ? nums1[e1--] : nums2[e2--];

            }
            if (e1 >= 0) {
                nums1[end--] = nums1[e1--];
            }
            if (e2 >= 0) {
                nums1[end--] = nums2[e2--];
            }

        }
    }
}
