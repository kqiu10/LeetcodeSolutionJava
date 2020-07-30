package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : MinimumMovestoEqualArrayElementsII462;
 * Creator: Kane;
 * Date: 7/29/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: Sort

 */
public class MinimumMovestoEqualArrayElementsII462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i <= j) {
            res += (nums[j--] - nums[i++]);
        }
        return res;

    }
}
/**
 * Time complexity:O(n);
 * Worst Time complexity: O(n^2);
 * Space complexity: O(1);
 * Description: quickSelect;
 * 关联题目： 215， 296;
 */
class minMoves2II {
    public static int minMoves2II(int[] nums) {
        int res = 0;
        int median = KthLargestElementinanArray(nums, nums.length / 2 + 1);
        for (int num : nums) {
            res += Math.abs(median - num);
        }
        return res;
    }
    private static int KthLargestElementinanArray(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;


    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2II(new int[]{1,2,3}));
    }
}