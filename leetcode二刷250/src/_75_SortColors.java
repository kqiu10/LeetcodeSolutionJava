/**
 * Date: 3/9/21
 * Question Description:
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _75_SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int start = 0;
        int end = nums.length - 1;
        int pointer = 0;
        while (pointer <= end) {
            if (nums[pointer] == 1) {
                pointer++;
            } else if (nums[pointer] == 0) {
                swap(nums, pointer++, start++);
            } else {
                swap(nums, pointer, end--);
            }
        }
        return;

    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
