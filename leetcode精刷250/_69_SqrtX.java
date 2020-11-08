/**
 * Date: 11/8/20
 * Question Description
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer
 * part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _69_SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return right;
    }
}
