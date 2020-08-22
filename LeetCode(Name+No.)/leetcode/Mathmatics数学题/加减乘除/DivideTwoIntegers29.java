package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : DivideTwoIntegers29;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * +,-
 * 越界
 * = 0
 * Time complexity:O(logn * logn);
 * Space complexity: O(logn);
 */
public class DivideTwoIntegers29 {
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
        if (Lres >= Integer.MAX_VALUE) {
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = (int)(sign * Lres);
        }
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
