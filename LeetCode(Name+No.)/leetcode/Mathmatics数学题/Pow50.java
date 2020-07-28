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
 * Time complexity:O();
 * Space complexity: O();
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
