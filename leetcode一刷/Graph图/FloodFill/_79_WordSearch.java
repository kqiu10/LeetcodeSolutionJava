package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(不知道);
 * Space complexity: O(不知道);

 */
public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == word.charAt(0)) && exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start++)) return false;
            char c = board[i][j];
            board[i][j] = '*';
            boolean res = exist(board, i - 1, j, word, start)
                    || exist(board, i + 1, j, word, start)
                    || exist(board, i, j - 1, word, start)
                    || exist(board, i, j + 1, word, start);
            if (res) return true;
            board[i][j] = c;
        return false;
    }
}
