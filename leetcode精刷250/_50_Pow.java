/**
 * Date: 11/5/20
 * Question Description
 Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

 Example 1:

 Input: x = 2.00000, n = 10
 Output: 1024.00000
 Example 2:

 Input: x = 2.10000, n = 3
 Output: 9.26100
 Example 3:

 Input: x = 2.00000, n = -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

/**
 * Ex 5^(-5) = 5^(-2) * 5^(-2) * 5
 *           = (5^(-1) * 5^(-1)) * (5^(-1) * 5^(-1)) * 5
 *           = ((5^0*5^0*5) * (5^0*5^0*5) * 5 ) * ((5^0*5^0*5) * (5^0*5^0*5) * 5 ) * 5
 * Recursion
 * Time complexity:O(logn);
 * Space complexity: O(logn);
 */
public class _50_Pow {
    public static double myPow(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
