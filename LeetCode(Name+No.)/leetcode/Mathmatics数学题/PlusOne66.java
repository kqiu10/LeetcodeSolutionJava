package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : PlusOne66;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class PlusOne66 {
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
