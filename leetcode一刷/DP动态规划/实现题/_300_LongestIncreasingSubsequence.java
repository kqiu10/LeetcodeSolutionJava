package DP动态规划.实现题;
/**
 * Date: 10/28/20
 * Question Description
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

/**
 * Description:
 * 遍历整个数组，对任意新的元素X，如果X比答案数组的最后一个值大，就加入答案数组中，否则就在答案数组中寻找一个比X大的元素用二分法进行替换，
 * 所以进行替换代表我们不改变答案数组的长度，但是我们改变了潜在的最佳答案，想法是尝试使数组中每个位置的值尽可能的小，数组的实际顺序仅在我们添加数字时才会更改，
 * 否则只是一个“虚拟更改”，表示我们不更改当前顺序，但尝试减小每个数字，以便我们有更大的机会附加更多数字
 *
 * i,j 相当于res数组的起点和终点；
 * size相当于res数组的长度
 * Time complexity:O(nlogn);
 * Space complexity: O(n);

 */
public class _300_LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (res[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            res[j] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}
