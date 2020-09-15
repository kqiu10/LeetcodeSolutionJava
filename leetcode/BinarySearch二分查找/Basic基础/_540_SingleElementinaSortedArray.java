package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : _540_SingleElementinaSortedArray;
 * Creator: Kane;
 * Date: 8/14/20
 */

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice
 * except for one element which appears exactly once. Find this single element that appears only once.
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description:
 * for normal case
 * 1 1 5 5 7 7 8 8
 * nums[2n] = nums[2n + 1]
 * if it exists element appeared once
 * 1 1 5 7 7 8 8
 * after 5, nums[2n] != nums[2n];
 * before 5, nums[2n] = nums[2n + 1];
 *
 */
public class _540_SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;
        while (left < right) {
            int pivot = (right - left) / 2 + left;
            if (nums[2 * pivot] != nums[2 * pivot + 1] ) right = pivot;
            else left = pivot + 1;
        }
        return nums[2 * left];

    }
}
