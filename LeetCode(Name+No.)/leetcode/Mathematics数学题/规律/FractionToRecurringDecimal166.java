package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : FractionToRecurringDecimal166;
 * Creator: Kane;
 * Date: 7/28/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * 1. 0 + -
 * 2. 整数
 * 3. 小数 -> 循环
 */
public class FractionToRecurringDecimal166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        fractionToDecimal(-1,
                -2147483648);
    }
}
