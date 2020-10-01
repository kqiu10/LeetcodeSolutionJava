/**
 * Date: 9/30/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class test {
    public double myPow(double x, int n) {
        if (n > 0) return pow(x, n);
        else return 1.0 / pow(x, n);
    }
    private double pow(double x, int n) {
        if (x == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}