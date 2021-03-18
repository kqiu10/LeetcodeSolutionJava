package src; /**
 * Date: 12/4/20
 * Question Description
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:

 Input: [1,2,3,4,5]
 Output: true
 Example 2:

 Input: [5,4,3,2,1]
 Output: false
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= third) {
                third = nums[i];
            } else if (nums[i] >= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
