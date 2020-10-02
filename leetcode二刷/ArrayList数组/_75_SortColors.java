package ArrayList数组.bubbleSort;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : _75_SortColors;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class _75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index++, start++);
            } else if (nums[index] == 2) {
                swap(nums, index, end--);

            } else if (nums[index] == 1) {
                index++;
            }
        }
        return;


    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
