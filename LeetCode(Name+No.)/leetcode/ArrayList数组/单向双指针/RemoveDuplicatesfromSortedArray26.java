package ArrayList数组.单向双指针;
/**
 * Package Name : 数组.单双向指针;
 * File name : RemoveDuplicatesfromSortedArray26;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: len之前的保留数，len所处的属于待定数。
 */
public class RemoveDuplicatesfromSortedArray26 {
    public  static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[len-1]) {
                nums[len++] = nums[i];
            }
        }
        System.out.println("nums is " + Arrays.toString(nums));
        return len;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 1, 1, 1, 2});
    }
}
