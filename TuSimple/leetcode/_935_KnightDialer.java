/**
 * Date: 2/28/21
 * Question Description:
 * The chess knight has a unique movement, it may move two squares vertically and one square
 * horizontally, or two squares horizontally and one square vertically (with both forming the
 * shape of an L). The possible movements of chess knight are shown in this diagaram:
 *
 * A chess knight can move as indicated in the chess diagram below:
 *
 *
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric
 * cell (i.e. blue cell).
 *
 *
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 *
 * You are allowed to place the knight on any numeric cell initially and then you should perform
 * n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.
 *
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell
 * of the 10 cells is sufficient.
 * Example 2:
 *
 * Input: n = 2
 * Output: 20
 * Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49,
 * 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * Example 3:
 *
 * Input: n = 3
 * Output: 46
 * Example 4:
 *
 * Input: n = 4
 * Output: 104
 * Example 5:
 *
 * Input: n = 3131
 * Output: 136006598
 * Explanation: Please take care of the mod.
 */

import java.util.HashMap;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class _935_KnightDialer {
    final int[][] dirs = new int[][]{{-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, -1}, {2, 1}};
    final int MAX = (int)Math.pow(10, 9) + 7;
    HashMap<String, Long> pathCount = new HashMap<>();
    public int knightDialer(int n) {
        int[][] phone = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        long res = 0;
        for (int i = 0; i < phone.length; i++) {
            for (int j = 0; j < phone[0].length; j++) {
                res = ((res + helper(phone, i, j, n))) % MAX;
            }
        }
        return (int)res;
    }
    private long helper(int[][] phone, int i, int j, int n) {
        if (i < 0 || i >= phone.length || j < 0 || j >= phone[0].length || phone[i][j] == -1) return 0;
        if (n == 1) {
            return 1;
        }
        String key = i +""+j+n;
        if (pathCount.containsKey(key)) {
            return pathCount.get(key);
        }
        long ans = 0;
        for (int[] dir : dirs) {
            ans += helper(phone, i + dir[0], j + dir[1], n - 1) % MAX;
        }
        pathCount.put(key, ans);
        return ans;
    }
}
