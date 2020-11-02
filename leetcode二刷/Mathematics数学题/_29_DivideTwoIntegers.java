package leetcode二刷.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : _29_DivideTwoIntegers;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For
 * example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 *
 *
 * +,-
 * 越界
 * = 0
 * Time complexity:O(logn * logn);
 * Space complexity: O(logn);
 */
public class _29_DivideTwoIntegers {
    public static int divide(int divided, int divisor) {
        int sign = 1;
        if ((divided > 0 && divisor < 0) || (divided < 0 && divisor > 0)) {
            sign = -1;
        }
        long Ldivided = Math.abs((long) divided);
        long Ldivisor = Math.abs((long) divisor);
        if (Ldivided < Ldivisor || Ldivided == 0) {
            return 0;
        }
        long Lres = divide(Ldivided, Ldivisor);
        int res = 0;
        if (Lres > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        res = (int)Lres * sign;
        return res;
    }
    public static long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return  multiple + divide(ldividend - sum, ldivisor);
    }

    public  static void main(String[] args) {
        System.out.println(divide(-2147483648,
                -1));
    }
}
