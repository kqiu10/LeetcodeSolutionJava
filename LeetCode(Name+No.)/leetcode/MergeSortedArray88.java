package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : MergeSortedArray88;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i>= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2 , 3);
        System.out.println(Arrays.toString(nums1));
    }
}
