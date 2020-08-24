package BinarySearch二分查找.递增递减;
/**
 * Package Name : BinarySearch二分查找.递增递减;
 * File name : _354_RussianDollEnvelopes;
 * Creator: Kane;
 * Date: 8/15/20
 */

import java.util.Arrays;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One
 * envelope can fit into another if and only if both the width and height of one envelope is
 * greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Note:
 * Rotation is not allowed.
 * Example:
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 *
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description:
 * Question Number 300's follow up.
 */
public class _354_RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ?  b[1] - a[1] : a[0] - b[0]));
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0 , res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) res++;
        }
        return res;
    }
    public static int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (dp[mid] == target) return mid;
            else if (dp[mid] < target) start = mid;
            else end = mid;
        }
        if (dp[start] >= target) return start;
        return end;
    }

    public static void main(String[] args) {
        maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
    }



}
