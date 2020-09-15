package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : PlusOne66;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Given a non-empty array of digits representing a non-negative integer, increment one to the
 * integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and
 * each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Time complexity:O();
 * Space complexity: O();
 */
public class _66_PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        /**
         * corner case : 999;
         * digits = {0, 0, 0};
         */
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }

    public static void main(String[] args) {

        plusOne(new int[]{9,9,9});
    }
}
