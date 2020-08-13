package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic;
 * File name : FindFirstandLastPositionofElementinSortedArray34;
 * Creator: Kane;
 * Date: 8/12/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class FindFirstandLastPositionofElementinSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = findStart(nums, target);
        if (start == -1) return new int[]{-1, -1};
        int end = findEnd(nums,target);
        return new int[]{start, end};
    }
    public int findStart(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;

    }
    public int findEnd(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;
    }
}
