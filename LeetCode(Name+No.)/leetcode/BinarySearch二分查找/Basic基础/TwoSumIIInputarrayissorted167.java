package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : TwoSumIIInputarrayissorted167;
 * Creator: Kane;
 * Date: 8/13/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class TwoSumIIInputarrayissorted167 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] + nums[end] < target) start++;
            else if (nums[start] + nums[end] > target) end--;
            else return new int[]{start + 1, end + 1};
        }
        return new int[]{-1, -1};

    }
}
