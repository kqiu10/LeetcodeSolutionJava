package 数组.交换;
/**
 * Package Name : 数组.交换;
 * File name : FirstMissingPositive41;
 * Creator: Kane;
 * Date: 8/6/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class FirstMissingPositive41 {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp =  nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{3, 4, -1, 1});
    }
}
