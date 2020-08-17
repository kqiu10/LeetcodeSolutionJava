package 数组.单向双指针;
/**
 * Package Name : 数组.单双向指针;
 * File name : RemoveElement27;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
