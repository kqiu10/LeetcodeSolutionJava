package ArrayList数组.单向双指针;
/**
 * Package Name : 数组.单向双指针;
 * File name : RemoveDuplicatesfromSortedArrayII;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O();n
 * Space complexity: O(1);
 * Description: count之前的保留数，count所处的属于待定数。
 */
public class RemoveDuplicatesfromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;

    }
}
