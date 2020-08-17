package ArrayList数组.bubbleSort; /**
 * Package Name : PACKAGE_NAME;
 * File name : moveZeros;
 * Creator: Kane;
 * Date: 7/18/20
 */

/**
 *Time complexity:O(n);
 * Space complexity: O(1);
 * Description: 0多的情况
 * number of operation : 2 * num of non-zero;
 */
public class moveZeros283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int idx = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
        return;

    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: 0少的情况
 * number of operation : nums.length
 */
class moveZerosII{
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = 0;
            }
        }
        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }
        return;

    }

}
