/**
 * Date: 11/4/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int pivot = (right - left) / 2 + left;
            if (nums[pivot] == target) return pivot;
            if (nums[left] < nums[pivot]) {
                if (nums[left] <= target && target <= nums[pivot]) {
                    right = pivot;
                }
                else {
                    left = pivot;
                }
            } else {
                if (nums[pivot] <= target && nums[right] >= target) {
                    left = pivot;
                }
                else {
                    right = pivot;
                }
            }

        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;

    }
}
