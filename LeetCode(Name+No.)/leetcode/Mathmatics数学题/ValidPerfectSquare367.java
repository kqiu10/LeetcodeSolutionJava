package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : ValidPerfectSquare367;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
       return false;


    }
}
