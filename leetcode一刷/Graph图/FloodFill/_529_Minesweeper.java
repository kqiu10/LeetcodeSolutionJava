package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 Let's play the minesweeper game (Wikipedia, online game)!

 You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

 Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

 If a mine ('M') is revealed, then the game is over - change it to 'X'.
 If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 Return the board when no more squares will be revealed.


 Example 1:

 Input:

 [['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

 Click : [3,0]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Explanation:

 Example 2:

 Input:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Click : [1,2]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 */

/**
 * Description: TODO
 * Time complexity:O(row * col);
 * Space complexity: O(1);

 */
public class _529_Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') return;
        int mineNum = findMine(board, x, y);
        if (mineNum == 0) {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    dfs(board, x + i, y + i);
                }
            }
        }
        board[x][y] = (char)('0' + mineNum);
    }

    private int findMine(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX < 0 || newY >= board.length || newY < 0 || newY >= board[0].length ) continue;

                if (board[newX][newY] == 'M') {
                    count++;
                }

            }
        }
        return count;
    }
}
