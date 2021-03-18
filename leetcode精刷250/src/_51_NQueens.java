package src; /**
 * Date: 11/6/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 Example:

 Input: 4
 Output: [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * Time complexity:O(n * n);
 * Space complexity: O(n);

 */
public class _51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, new int[n], 0);
        return res;
    }
    private void helper(List<List<String>> res, int[] rows, int pos) {
        if (pos == rows.length) {
            addResult(res, rows);
            return;
        }
        for (int i = 0; i < rows.length; i++) {
            rows[pos] = i;
            if (isValid(rows, pos)) {
                helper(res, rows, pos + 1);
            }
        }
    }
    private boolean isValid(int[] rows, int pos) {
        for (int i = 0; i < pos; i++) {
            if (rows[i] == rows[pos]) return false;
            if (Math.abs(rows[i] - rows[pos]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }
    private void addResult(List<List<String>> res, int[] rows) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < rows.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rows.length; j++) {
                if (rows[j] == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
