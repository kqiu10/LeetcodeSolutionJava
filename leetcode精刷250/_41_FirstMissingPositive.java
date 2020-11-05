/**
 * Date: 11/5/20
 * Question Description
 Given an unsorted integer array nums, find the smallest missing positive integer.

 Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 Example 1:

 Input: nums = [1,2,0]
 Output: 3
 Example 2:

 Input: nums = [3,4,-1,1]
 Output: 2
 Example 3:

 Input: nums = [7,8,9,11,12]
 Output: 1

 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
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
}
