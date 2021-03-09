/**
 * Date: 3/9/21
 * Question Description:
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct
 * values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k <
 * nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
 * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at
 * pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in
 * nums, or false if it is not in nums.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target || nums[right] == target;

    }
}
