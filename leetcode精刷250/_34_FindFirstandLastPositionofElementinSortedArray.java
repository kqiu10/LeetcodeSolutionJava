/**
 * Date: 11/4/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = findFirst(nums, 0, nums.length - 1, target);
        if (start == -1) return new int[]{-1, -1};
        int end = findLast(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }
    private int findFirst(int[] nums, int left, int right, int target) {
        while (left + 1< right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
    private int findLast(int[] nums, int left, int right, int target) {
        while (left + 1< right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) return right;
        if (nums[left] == target) return left;
        return -1;
    }
}
