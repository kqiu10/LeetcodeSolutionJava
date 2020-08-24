package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : StringToInteger;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets
 * them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which
 * are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or
 * if no such sequence exists because either str is empty or it contains only whitespace
 * characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of
 * representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 *
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class _8_StringToInteger {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int signal = 1;
        int start = 0;
        long res = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            signal = 1;
            start++;
        } else if (firstChar == '-') {
            signal = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)(res * signal);
            }
             res = res * 10 + (str.charAt(i) - '0');
            if (signal == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (signal == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return (int)(res * signal);

    }

    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }
}
