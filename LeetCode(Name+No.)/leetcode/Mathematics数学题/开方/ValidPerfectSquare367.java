package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : ValidPerfectSquare367;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
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
    /**
     * Time complexity:O(n);
     * Space complexity: O(1);
     */
    public boolean isPerfectSquareII(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 0; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
    /**
     * Time complexity:O(n);
     * Space complexity: O(1);
     * 完全平方数是奇数的和;
     * 1 = 1;
     * 4 = 1 + 3;
     * 9 = 1 + 3 + 5;
     */
    public boolean isPerfectSquareIII(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;

    }
    /**
     * Time complexity:unknown;
     * Space complexity: O(1);
     * Newton Method
     * Web : https://www.zhihu.com/question/20690553?;
     * 公式 熟记
     */
    public boolean isPerfectSquareIV(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;

    }
}
