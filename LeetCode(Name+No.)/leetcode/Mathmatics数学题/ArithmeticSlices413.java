package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : ArithmeticSlices413;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * 数组                    等差数列个数                  与上一数组的等差数列数目比较
 * 1 2 3                      1                            1 - 0 = 1
 * 1 2 3 4                    3                            3 - 1 = 2
 * 1 2 3 4 5                  6                            6 - 3 = 3
 * 1 2 3 4 5 6                10                           10 - 6 = 4
 * 1 2 3 4 5 6 7              15                           15 - 10 = 5
 */
public class ArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, res = 0;
        for (int i = 2; i < A.length; i++) {
            if ((A[i] - A[i-1]) == (A[i-1] - A[i-2])) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
