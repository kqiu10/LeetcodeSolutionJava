package 数组.交换;
/**
 * Package Name : 数组.交换;
 * File name : WiggleSort280;
 * Creator: Kane;
 * Date: 8/6/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class WiggleSort280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) && nums[i] > nums[i + 1] || (i % 2 != 0) && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }

    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
