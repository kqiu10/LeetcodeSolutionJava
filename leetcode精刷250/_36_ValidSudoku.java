/**
 * Date: 11/4/20
 * Question Description
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 */

import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O(n ^ 2);
 * Space complexity: O(n);

 */
public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return true;
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < c; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' &&  !col.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !box.add(board[rowIndex + j / 3][colIndex + j % 3])) return false;
            }
        }
        return true;
    }
}
