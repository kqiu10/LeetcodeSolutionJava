package BinarySearch二分查找.二维数组;
/**
 * Package Name : BinarySearch二分查找.二维数组;
 * File name : BattleshipsinaBoard419;
 * Creator: Kane;
 * Date: 8/15/20
 */

/**
 * Given an 2D board, count how many battleships are in it. The battleships are represented with
 * 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be
 * made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no
 * adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 *
 * Time complexity:O(m * n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class BattleshipsinaBoard419 {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                res++;
            }
        }
        return res;

    }

}
