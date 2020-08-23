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
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num,res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
