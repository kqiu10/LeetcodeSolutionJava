/**
 * Date: 11/6/20
 * Question Description
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */

/**
 * Description: TODO
 * Time complexity:O(n * n);
 * Space complexity: O(n);

 */
public class _52_NQueensII {
    static int res = 0;
    public static int totalNQueens(int n) {
        if (n <= 0) return 0;
        helper(new int[n], 0);
        return res;
    }
    private static void helper(int[] rows, int pos) {
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
    private static boolean isValid(int[] rows, int pos) {
        for (int i = 0; i < pos; i++) {
            if (rows[i] == rows[pos]) return false;
            if (Math.abs(rows[i] - rows[pos]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        totalNQueens(4);
    }
}
