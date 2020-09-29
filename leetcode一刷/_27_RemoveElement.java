/**
 * Description:
 * Package Name : PACKAGE_NAME;
 * File name : _27_RemoveElement;
 * Creator: Kane;
 * Date: 7/18/20
 */
package leetcode;
public class _27_RemoveElement {
    public static int _27_removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[res++] = nums[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2};
        _27_removeElement(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }

    }
}
