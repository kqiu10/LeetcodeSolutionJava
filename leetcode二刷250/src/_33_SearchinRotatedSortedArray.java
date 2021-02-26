/**
 * Date: 2/25/21
 * Question Description:
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k <
 * nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
 * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot
 * index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if
 * it is in nums, or -1 if it is not in nums.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1< right) {
            int pivot = (right - left) / 2 + left;
            if (nums[pivot] == target) return pivot;
            if (nums[left] < nums[pivot]) {
                if (nums[left] <= target && nums[pivot] >= target) {
                    right = pivot;
                } else {
                    left = pivot;
                }
            } else {
                if (nums[pivot] <= target && nums[right] >= target) {
                    left = pivot;
                } else {
                    right = pivot;
                }
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

}
