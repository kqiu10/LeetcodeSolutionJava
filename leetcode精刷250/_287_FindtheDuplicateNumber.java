/**
 * Date: 11/29/20
 * Question Description
 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

 There is only one duplicate number in nums, return this duplicate number.

 Follow-ups:

 How can we prove that at least one duplicate number must exist in nums?
 Can you solve the problem without modifying the array nums?
 Can you solve the problem using only constant, O(1) extra space?
 Can you solve the problem with runtime complexity less than O(n2)?


 Example 1:
 Input: nums = [1,3,4,2,2]
 Output: 2

 Example 2:
 Input: nums = [3,1,3,4,2]
 Output: 3

 Example 3:
 Input: nums = [1,1]
 Output: 1

 Example 4:
 Input: nums = [1,1,2]
 Output: 1
 */


public class _287_FindtheDuplicateNumber {
    /**
     * Time complexity:O(n);
     * Space complexity: O(1);
     * Description: 142 Lined List Cycle；
     * 代码参考：https://segmentfault.com/a/1190000003817671；
     */
    public  int findDuplicateII(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        int find = 0;
        while (find != slow) {
            find = nums[find];
            slow = nums[slow];
        }
        return slow;
    }
    /**
     * Description: 交换
     * Time complexity:O(n^2);
     * Space complexity: O(1);
     */
    public  int findDuplicateIII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return -1;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;


    }

    /**
     * Time complexity:O(nlogn);
     * Space complexity: O(1);
     * Description: 二分法；
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int count = 0;
            int mid = (max - min) / 2 + min;
            for (int i = 0; i< nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }

}
