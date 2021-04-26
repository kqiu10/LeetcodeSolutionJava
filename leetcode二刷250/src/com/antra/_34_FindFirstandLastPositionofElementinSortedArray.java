package com.antra;
/**
 * Date: 4/24/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _34_FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        int l = findLeft(nums, left, right, target);
        int r = findRight(nums, left, right, target);
        return new int[]{l, r};
    }
    private int findLeft(int[] nums, int l, int r, int target) {
        while (l + 1< r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    private int findRight(int[] nums, int l, int r, int target) {
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;
    }
}
