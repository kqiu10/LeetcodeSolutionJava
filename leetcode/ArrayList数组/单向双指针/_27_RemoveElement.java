package ArrayList数组.单向双指针;
/**
 * Package Name : 数组.单双向指针;
 * File name : _27_RemoveElement;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _27_RemoveElement {
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
