/**
 * Date: 11/29/20
 * Question Description
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]

 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _283_MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        int index = 0;
        int end = nums.length - 1;
        while (index <= end) {
            if (nums[index] == 0) {
                index++;
            } else {
                swap(nums, start++, index++);
            }
        }
        return;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
