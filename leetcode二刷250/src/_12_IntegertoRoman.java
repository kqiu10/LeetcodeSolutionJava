/**
 * Date: 2/17/21
 * Question Description
 * Examples:
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _12_IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                res.append(romans[i]);
                num -= nums[i];
            }
        }
        return res.toString();
    }
}
