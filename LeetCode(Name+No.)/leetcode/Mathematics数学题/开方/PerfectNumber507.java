package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : PerfectNumber;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(sqrt(n));
 * Space complexity: O(1);
 */
public class PerfectNumber507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int res = 1;
        for (int i = 2; i<= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += (i + num / i);
            }
        }
        return res == num;


    }
}
