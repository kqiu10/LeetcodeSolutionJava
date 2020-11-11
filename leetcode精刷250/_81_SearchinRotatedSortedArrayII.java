/**
 * Date: 11/10/20
 * Question Description
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.
 Example 1:
 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[pivot] == target) return true;
            if (nums[l] == nums[pivot] && nums[pivot] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[pivot]) {
                if (nums[l] <= target && target <= nums[pivot]) r = pivot;
                else l = pivot;
            } else {
                if (nums[pivot] <= target && nums[r] >= target) l = pivot;
                else r = pivot;
            }
        }
        if (nums[l] == target || nums[r] == target) return true;
        return false;

    }
}
