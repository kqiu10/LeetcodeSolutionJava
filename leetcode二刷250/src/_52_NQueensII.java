/**
 * Date: 3/4/21
 * Question Description:
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Examples:
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 */

/**
 * Time Complexity: O(n*n)
 * Space Complexity: O(n)
 */
public class _52_NQueensII {
    int res = 0;
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        helper(new int[n], 0);
        return res;
    }
    private void helper(int[] rows, int pos) {
        if (pos == rows.length) {
            res += 1;
            return;
        }
        for (int i = 0; i < rows.length; i++) {
            rows[pos] = i;
            if (isValid(rows, pos)) {
                helper(rows, pos + 1);
            }
        }
    }
    private boolean isValid(int[] rows, int pos) {
        for (int i = 0; i< pos; i++) {
            if (rows[i] == rows[pos]) return false;
            if (Math.abs(rows[i] - rows[pos]) == Math.abs(i - pos)) return false;

        }
        return true;
    }
}
