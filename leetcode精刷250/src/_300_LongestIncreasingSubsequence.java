package src;

/**
 * Date: 11/30/20
 * Question Description
 Given an integer array nums, return the length of the longest strictly increasing subsequence.

 A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 Example 1:

 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Example 2:

 Input: nums = [0,1,0,3,2,3]
 Output: 4
 Example 3:

 Input: nums = [7,7,7,7,7,7,7]
 Output: 1
 */


public class _300_LongestIncreasingSubsequence {
    /**
     * Description: DP
     * Time complexity:O(n^2);
     * Space complexity: O(n^2);
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cur = Math.max(cur, dp[j]);
                }
            }
            dp[i] = cur + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    /**
     * Time complexity:O(nlogn);
     * Space complexity: O(n);
     * Description:
     * 遍历整个数组，对任意新的元素X，如果X比答案数组的最后一个值大，就加入答案数组中，否则就在答案数组中寻找一个比X大的元素用二分法进行替换，
     * 所以进行替换代表我们不改变答案数组的长度，但是我们改变了潜在的最佳答案，想法是尝试使数组中每个位置的值尽可能的小，数组的实际顺序仅在我们添加数字时才会更改，
     * 否则只是一个“虚拟更改”，表示我们不更改当前顺序，但尝试减小每个数字，以便我们有更大的机会附加更多数字
     *
     * i,j 相当于res数组的起点和终点；
     * size相当于res数组的长度
     */
    public int lengthOfLISII(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (dp[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            dp[j] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

}
