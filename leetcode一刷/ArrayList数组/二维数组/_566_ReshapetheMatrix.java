package ArrayList数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : _566_ReshapetheMatrix;
 * Creator: Kane;
 * Date: 8/11/20
 */

/**
 * Time complexity:O(m * n);
 * Space complexity: O(r * c);
 * Description:
 * reshape a matrix, the row index 0f new element is value of element / column, the column index is value of element % column;
 * Ex 0 1 2
 *    3 4 5
 *    the location of 5 is (5 / 3， 5 % 3） == （1 , 2)
 */
public class _566_ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != m * n) return nums;
        int idx = 0;
        for (int[] row : nums) {
            for (int num : row) {
                res[idx / c][idx % c] = num;
                idx++;
            }

        }
        return res;

    }
}
