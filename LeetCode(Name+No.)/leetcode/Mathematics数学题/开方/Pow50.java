package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : Pow50;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Ex 5^(-5) = 5^(-2) * 5^(-2) * 5
 *           = (5^(-1) * 5^(-1)) * (5^(-1) * 5^(-1)) * 5
 *           = ((5^0*5^0*5) * (5^0*5^0*5) * 5 ) * ((5^0*5^0*5) * (5^0*5^0*5) * 5 ) * 5
 * Recursion
 * Time complexity:O(logn);
 * Space complexity: O(logn);
 */
public class Pow50 {
    public static double myPow(double x, int n) {
        if (n > 0) {
            return pow(x,n);
        } else {
            return 1.0 / pow(x,n);
        }
    }
    public static double pow(double x, int n) {
        if(n == 0) return 1;
        double y = pow(x, n /2);
        if(n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(5, 5));
    }
}
/**
 * Iteration
 * Time complexity:O(logn); //二分法;
 * Space complexity: O(1);
 */

class PowII{
    public static double Pow(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
                x *= x;
                abs /= 2;

        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Pow(5, 5));
    }

}
