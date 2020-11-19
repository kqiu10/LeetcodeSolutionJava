/**
 * Date: 11/18/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _154_FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[l] == nums[pivot] && nums[pivot] == nums[r]) {
                l++;
                r--;
            }
            if (nums[pivot] < nums[r]) {
                r = pivot;
            } else if (nums[pivot] > nums[r]) {
                l = pivot;
            } else {
                //corner case : 1 1 1 1 2 1
                r--;
            }
        }
        if (nums[l] < nums[r]) return nums[l];
        else return nums[r];
    }
}
