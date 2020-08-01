package leetcode.Mathmatics数学题;
/**
 * Description: mid = (high - low) / 2 + low 而不是 mid = (high + low) / 2 是解决越界问题
 * Package Name : leetcode.Mathmatics数学题;
 * File name : Sqrt69;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 */
public class Sqrt69 {
    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        int low = 1;
        int high = x;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        if (high * high < x) {
            return high;
        } else {
            return low;
        }

    }
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}
class mySqrtII {
    public int mySqrtII(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
