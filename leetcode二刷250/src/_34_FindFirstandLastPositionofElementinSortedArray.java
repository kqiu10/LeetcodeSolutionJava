/**
 * Date: 2/25/21
 * Question Description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending
 * position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * Examples:'
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = findStart(nums, target, 0, nums.length - 1);
        if (start == -1) return new int[]{-1, -1};
        int end = findEnd(nums, target, 0, nums.length - 1);
        return new int[]{start, end};
    }
    private int findStart(int[] nums, int target, int l, int r) {
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[pivot] < target) {
                l = pivot;
            } else {
                r = pivot;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    private int findEnd(int[] nums, int target, int l, int r) {
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[pivot] > target) {
                r = pivot;
            } else {
                l = pivot;
            }
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;
    }
}
