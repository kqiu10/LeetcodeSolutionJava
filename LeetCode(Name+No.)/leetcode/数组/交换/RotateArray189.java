package 数组.交换;
/**
 * Package Name : 数组.交换;
 * File name : RotateArray189;
 * Creator: Kane;
 * Date: 8/6/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
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
