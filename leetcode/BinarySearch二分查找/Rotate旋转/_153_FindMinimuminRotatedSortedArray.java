package BinarySearch二分查找.Rotate旋转;
/**
 * Package Name : BinarySearch二分查找.Rotate旋转;
 * File name : _153_FindMinimuminRotatedSortedArray;
 * Creator: Kane;
 * Date: 8/14/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description:
 * two edge cases
 * 4 5 6 7 0 1 2
 *
 * 4 5 6 0 1 2 3
 */
public class _153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[r] < nums[pivot]) l = pivot + 1;
            else r = pivot;
        }
        if (nums[l] < nums[r]) return nums[l];
        else return nums[r];

    }
}
