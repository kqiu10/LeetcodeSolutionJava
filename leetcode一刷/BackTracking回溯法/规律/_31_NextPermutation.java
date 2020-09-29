package leetcode.BackTracking回溯法.规律;
/**
 * Package Name : leetcode.BackTracking回溯法.规律;
 * File name : _31_NextPermutation;
 * Creator: Kane;
 * Date: 9/15/20
 */

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 * in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 *    // 1   2   7   4   3   1
 *           ^
 *    // 1   2   7   4   3   1
 *                       ^
 *    // 1   3   7   4   2   1
 *           ^           ^
 *    // 1   3   1   2   4   7
 *               ^   ^   ^   ^
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }

        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a++] = nums[b];
        nums[b--] = temp;
    }

    private void reverse(int[] nums, int a, int b) {
        while (a < b) {
            swap(nums, a++, b--);
        }
    }
}
