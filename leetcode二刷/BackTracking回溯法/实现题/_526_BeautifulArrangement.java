package leetcode.BackTracking回溯法.实现题;
/**
 * Package Name : leetcode.BackTracking回溯法.实现题;
 * File name : __526__BeautifulArrangement;
 * Creator: Kane;
 * Date: 9/16/20
 */

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is
 * constructed by these N numbers successfully if one of the following is true for the ith
 * position (1 <= i <= N) in this array:
 *
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 *
 *
 * Now given N, how many beautiful arrangements can you construct?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation:
 *
 * The first beautiful arrangement is [1, 2]:
 *
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 *
 * The second beautiful arrangement is [2, 1]:
 *
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 *
 * Time complexity:O(n!);
 * Space complexity: O(n);
 * Description: permutation
 */
public class _526_BeautifulArrangement {
    int res;
    public int countArrangement(int N) {
        res = 0;
        helper(new boolean[N + 1], N, 1);
        return res;

    }
    private void helper(boolean[] visited, int N, int pos) {
        if (pos > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && ((i % pos == 0) || (pos % i == 0))) {
                visited[i] = true;
                helper(visited, N, pos + 1);
                visited[i] = false;
            }
        }
    }
}
