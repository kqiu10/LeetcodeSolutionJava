package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : Base7;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 */
public class _504_Base7 {
    /**
     * Given an integer, return its base 7 string representation.
     *
     * Example 1:
     * Input: 100
     * Output: "202"
     * Example 2:
     * Input: -7
     * Output: "-10"
     *
     * method : iteration;
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        if (negative == true) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
    /**
     * recursion
     */
    public static String convertToBase7II(int num) {
        if (num < 0) {
            return '-' + convertToBase7II(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase7II(num / 7) + num % 7;
    }

    public static void main(String[] args) {
        convertToBase7II(12);
        System.out.println(convertToBase7II(12));
    }
}
