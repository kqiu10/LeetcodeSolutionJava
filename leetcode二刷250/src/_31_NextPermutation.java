/**
 * Date: 2/25/21
 * Question Description:
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e
 * ., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * 1    2   7   4   3   1
 *      ^
 * 1    2   7   4   3   1
 *                  ^
 * 1    3   7   4   2   1
 *      ^           ^
 * 1    3   1   2   4   7
 *          ^   ^   ^   ^
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
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
       for (int i = nums.length -1; i > firstSmall; i--) {
           if (nums[i] > nums[firstSmall]) {
               firstLarge = i;
               break;
           }
       }
       swap(nums, firstLarge, firstSmall);
       reverse(nums, firstSmall + 1, nums.length - 1);
       return;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
        return;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
