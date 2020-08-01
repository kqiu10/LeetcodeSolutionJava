package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : FactorialTrailingZeros;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(n);
 * Description: 2 * 5 = 10
 * 5出现的次数远小于2出现的次数，所以只需要求得5出现的次数即可
 */
public class FactorialTrailingZeros172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
