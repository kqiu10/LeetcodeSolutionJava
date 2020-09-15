package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : _413_ArithmeticSlices;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if
 * the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 *
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of
 * integers (P, Q) such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of the array A is called arithmetic if the sequence:
 * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 *
 *
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
public class _413_ArithmeticSlices {
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
