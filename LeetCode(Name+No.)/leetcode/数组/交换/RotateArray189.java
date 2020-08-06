package 数组.交换;
/**
 * Package Name : 数组.交换;
 * File name : RotateArray189;
 * Creator: Kane;
 * Date: 8/6/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: Using Extra Array
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Using Reverse
 * Original List                   : 1 2 3 4 5 6 7
 * After reversing all numbers     : 7 6 5 4 3 2 1
 * After reversing first k numbers : 5 6 7 4 3 2 1
 * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */
class RotateArrayII{
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp =nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
