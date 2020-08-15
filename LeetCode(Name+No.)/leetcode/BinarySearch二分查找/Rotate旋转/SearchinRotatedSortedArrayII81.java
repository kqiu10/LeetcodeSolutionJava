package BinarySearch二分查找.Rotate旋转;
/**
 * Package Name : BinarySearch二分查找.Rotate旋转;
 * File name : SearchinRotatedSortedArrayII81;
 * Creator: Kane;
 * Date: 8/14/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description:
 * edge case : 1 1 1 3 1
 */
public class SearchinRotatedSortedArrayII81 {
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
                else l = pivot + 1;
            } else {
                if (nums[pivot] <= target && nums[r] >= target) l = pivot + 1;
                else r = pivot;
            }
        }
        if (nums[l] == target || nums[r] == target) return true;
        return false;

    }
}
