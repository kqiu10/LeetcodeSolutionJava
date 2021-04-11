package src; /**
 * Date: 11/2/20
 * Question Description
 Given a 32-bit signed integer, reverse digits of an integer.

 Note:
 Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 Example 1:

 Input: x = 123
 Output: 321
 Example 2:

 Input: x = -123
 Output: -321
 Example 3:

 Input: x = 120
 Output: 21
 Example 4:

 Input: x = 0
 Output: 0
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _7_ReverseInteger {
    public int reverse(int x) {
        int signal = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res * signal;
        }


    }
}
