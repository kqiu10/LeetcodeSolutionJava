package leetcode; /**
 * Description: TODO
 * Package Name : PACKAGE_NAME;
 * File name : moveZeros;
 * Creator: Kane;
 * Date: 7/18/20
 */

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class moveZeros283 {
    public void moveZeroes(int[] nums) {
       if (nums == null || nums.length == 0) {
           throw new IndexOutOfBoundsException();
       }
       int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }

        }
    }
}
