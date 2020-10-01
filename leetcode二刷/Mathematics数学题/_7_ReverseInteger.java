package leetcode.Mathmatics数学题;
/**
 * Description: int range : [−2^31,  2^31 − 1];
 * corner case : 越界；
 * Package Name : leetcode.Mathmatics数学题;
 * File name : _7_ReverseInteger;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Time complexity:O(logn);
 * Space complexity: O(1);
 */
public class _7_ReverseInteger {
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)res;


    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
