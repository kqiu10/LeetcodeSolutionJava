/**
 * Date: 11/10/20
 * Question Description
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example 1:
 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 Output: true
 Example 2:
 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 Output: true
 */

/**
 * Description: TODO
 * Time complexity:O(unknown);
 * Space complexity: O(unknown);

 */
public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(pos++) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean exists = exist(board, i - 1, j, word, pos) || exist(board, i + 1, j, word, pos) || exist(board, i, j - 1, word, pos) || exist(board, i, j + 1, word, pos);
        if (exists) return true;
        board[i][j] = c;
        return false;

    }
}
