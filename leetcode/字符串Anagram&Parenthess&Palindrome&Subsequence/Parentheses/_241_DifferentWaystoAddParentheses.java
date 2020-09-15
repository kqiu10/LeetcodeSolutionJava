package Parentheses;
/**
 * Package Name : Parentheses;
 * File name : _241_DifferentWaystoAddParentheses;
 * Creator: Kane;
 * Date: 9/5/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * Time complexity:O(n^3);不确定
 * Space complexity: O(n);
 * Description:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class _241_DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String l1 = input.substring(0, i);
                String r1 = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(l1);
                List<Integer> ar = diffWaysToCompute(r1);
                for (int l : al) {
                    for (int r : ar) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }

        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
