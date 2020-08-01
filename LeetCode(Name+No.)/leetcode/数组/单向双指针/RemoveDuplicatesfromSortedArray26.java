package 数组.单向双指针;
/**
 * Package Name : 数组.单双向指针;
 * File name : RemoveDuplicatesfromSortedArray26;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class RemoveDuplicatesfromSortedArray26 {
    public  static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }
}
