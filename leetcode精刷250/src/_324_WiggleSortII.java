package src;

import java.util.Arrays;

/**
 * Date: 12/4/20
 * Question Description
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example 1:

 Input: nums = [1, 5, 1, 1, 6, 4]
 Output: One possible answer is [1, 4, 1, 5, 1, 6].
 Example 2:

 Input: nums = [1, 3, 2, 2, 3, 1]
 Output: One possible answer is [2, 3, 1, 3, 1, 2].
 */


public class _324_WiggleSortII {
    /**
     * Description:
     排序，找中位数
     大于中位数， 左 - 右， 奇
     小于中位数， 右 - 左， 偶
     中位数最后放

     Ex : 1 2 3 4 5 6
          ->
          3 6 2 5 1 4
     * Time complexity:O(nlogn);
     * Space complexity: O(1);

     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] copy = new int[n];
        int index = 0;
        int mid = (n - 1) / 2;
        for (int i = 0; i <= mid; i++) {
            copy[index] = nums[mid - i];
            if (index + 1 < n) {
                copy[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(copy, 0, nums, 0, n);
        return;
    }
}
