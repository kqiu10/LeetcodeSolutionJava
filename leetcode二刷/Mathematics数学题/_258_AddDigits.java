package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : AddDigits258;
 * Creator: Kane;
 * Date: 7/25/20
 * 1 : 1
 * 2 : 2
 * 3 : 3
 * 4 : 4
 * 5 : 5
 * 6 : 6
 * 7 : 7
 * 8 : 8
 * 9 : 9
 * 10 : 1
 * 11 : 2
 * 12 : 3
 * 13 : 4
 * 14 : 5
 * 15 : 6
 * 16 : 7
 * 17 : 8
 * 18 : 9
 */

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one
 * digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation:
 * The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Time complexity:O(1);
 * Space complexity: O(1);
 */
public class _258_AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;

    }
}

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 */
class AddDigitsII {

    public int addDigits(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
            if (num == 0 && res > 9) {
                num = res;
                res = 0;
            }
        }
        return res;

    }
}
