package src; /**
 * Date: 11/4/20
 * Question Description
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

 The replacement must be in place and use only constant extra memory.

 Example 1:

 Input: nums = [1,2,3]
 Output: [1,3,2]
 Example 2:

 Input: nums = [3,2,1]
 Output: [1,2,3]
 Example 3:

 Input: nums = [1,1,5]
 Output: [1,5,1]
 Example 4:

 Input: nums = [1]
 Output: [1]
 */

/**
 * Description:
 // 1    2   7   4   3   1
         ^
 // 1    2   7   4   3   1
                     ^
 // 1    3   7   4   2   1
         ^           ^
 // 1    3   1   2   4   7
             ^   ^   ^   ^
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstSmall = -1;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            swap(nums, 0, len - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                int temp = nums[firstSmall];
                nums[firstSmall] = nums[firstLarge];
                nums[firstLarge] = temp;
                break;
            }
        }
        swap(nums, firstSmall + 1, len - 1);
        return;
    }
    private void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

    }
}
