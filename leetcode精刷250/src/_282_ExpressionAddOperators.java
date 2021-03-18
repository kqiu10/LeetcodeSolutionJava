package src; /**
 * Date: 11/30/20
 * Question Description
 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Example 1:

 Input: num = "123", target = 6
 Output: ["1+2+3", "1*2*3"]
 Example 2:

 Input: num = "232", target = 8
 Output: ["2*3+2", "2+3*2"]
 Example 3:

 Input: num = "105", target = 5
 Output: ["1*0+5","10-5"]
 Example 4:

 Input: num = "00", target = 0
 Output: ["0+0", "0-0", "0*0"]
 Example 5:

 Input: num = "3456237490", target = 9191
 Output: []
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String str, String num, int target, int pos, long val, long pre) {
        if (pos == num.length() && val == target) {
            res.add(str);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, str + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, str + "+" + cur, num, target, i + 1, val + cur, cur);
                helper(res, str + "-" + cur, num, target, i + 1, val - cur, -cur);
                helper(res, str + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur - cur);
            }
        }
    }
}
