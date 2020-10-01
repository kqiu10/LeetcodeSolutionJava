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
    public int[] plusOne(int[] digits) {
        int sign = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] final = new int[digits.length + 1];
        final[0] = 1;
        return final;
    }

}