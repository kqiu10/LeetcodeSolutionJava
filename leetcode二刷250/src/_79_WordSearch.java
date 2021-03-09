/**
 * Date: 3/9/21
 * Question Description:
 * Given an m x n gird of characters board and a string word, return true if word exists in the
 * grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Note: There will be some test cases with a board or a word larger than constraints to test if
 * your solution is using pruning.
 * <p>
 * Examples:
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */

/**
 * Time Complexity: O(unknown)
 * Space Complexity: O(unknown)
 */
public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && exists(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exists(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos ++)) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean isExists = exists(board, i + 1, j, word, pos) || exists(board, i - 1, j, word, pos) || exists(board, i, j + 1, word, pos) || exists(board, i, j - 1, word, pos);
        if (isExists) return true;
        board[i][j] = temp;
        return false;
    }
}
