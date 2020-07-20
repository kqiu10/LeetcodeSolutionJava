package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : SortColors75;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if(nums[index] == 0) {
                swap(nums, index++, start++);
            } else if(nums[index] == 2) {
                swap(nums, index, end--);

            } else {
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
