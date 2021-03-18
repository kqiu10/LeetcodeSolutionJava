package src; /**
 * Date: 11/10/20
 * Question Description
 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Follow up:

 Could you solve this problem without using the library's sort function?
 Could you come up with a one-pass algorithm using only O(1) constant space?
 Example 1:

 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Example 2:

 Input: nums = [2,0,1]
 Output: [0,1,2]
 Example 3:

 Input: nums = [0]
 Output: [0]
 Example 4:

 Input: nums = [1]
 Output: [1]
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, start++, index++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, end--);
            }
        }
    }
    private void swap (int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
