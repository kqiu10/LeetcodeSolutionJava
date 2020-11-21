/**
 * Date: 11/20/20
 * Question Description
 Given an array, rotate the array to the right by k steps, where k is non-negative.

 Follow up:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?
 Example 1:

 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: nums = [-1,-100,3,99], k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k % nums.length - 1);
        swap(nums,  k % nums.length, nums.length - 1);
        return;
    }
    private void swap(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
