package ArrayList数组.特殊;
/**
 * Package Name : 数组.特殊;
 * File name : ValidSudoku36;
 * Creator: Kane;
 * Date: 8/12/20
 */

import java.util.HashSet;

/**
 * Time complexity:O(1); since all we do here is just one iteration over the board with 81 cells.
 * Space complexity: O(1);
 * Description:
 * int rowIndex = 3 * (i / 3);
 * int colIndex = 3 * (i % 3);
 * 0 1 2 3 4 5 6 7 8
 *
 * 0 0 0 3 3 3 6 6 6          rowIndex
 * 0 3 6 0 3 6 0 3 6          colIndex
 *
 * 0 0 0 1 1 1 2 2 2          j / 3
 * 0 1 2 0 1 2 0 1 0          j % 3
 *
 * i = 0 判断第一个九宫格， i= 1 判断第二个九宫格， 依次判断
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> square = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j /3][colIndex + j % 3] != '.' && !square.add(board[rowIndex + j /3][colIndex + j % 3])) return false;
            }
        }
        return true;

    }
}
