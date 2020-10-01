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
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int start = 0;
        int sign = 1;
        long res = 0;
        char first = str.charAt(0);
        if (first == '+') {
            start = 1;
            sign = 1;
        } else if (first == '-') {
            start = 1;
            sign = -1;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return sign * (int)res;
            }
             res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return sign * (int)res;

    }

}