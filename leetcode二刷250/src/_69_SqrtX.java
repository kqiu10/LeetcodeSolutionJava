/**
 * Date: 3/8/21
 * Question Description:
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer
 * part of the result is returned.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is
 * returned.
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _69_SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1;
        int r = x;
        while (l <= r) {
            long pivot = (r - l) / 2 + l;
            if (pivot * pivot == x) return (int)pivot;
            else if (pivot * pivot < x) {
                l = (int)pivot + 1;
            } else {
                r = (int)pivot - 1;
            }
        }
        return r;
    }
}
