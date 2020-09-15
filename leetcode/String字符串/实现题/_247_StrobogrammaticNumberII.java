package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _247_StrobogrammaticNumberII;
 * Creator: Kane;
 * Date: 9/1/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at
 * upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * Example:
 *
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 *
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 *  Description:
 *  n = 3  : ["101", "609", "808", "906", "111", "619", "818", "916", "181", "689", "888", "986"]
 *  cur = ["0", "1", "8"];
 *  m == 3 == n;
 */
public class _247_StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);

    }
    private List<String> helper(int m, int n) {
        if (m == 0) return new ArrayList<>(Arrays.asList(""));
        if (m == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> cur = helper(m - 2, n);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.size(); i++) {
            if (m != n) {
                res.add("0" + cur.get(i) + "0");
            }
            res.add("1" + cur.get(i) + "1");
            res.add("6" + cur.get(i) + "9");
            res.add("9" + cur.get(i) + "6");
            res.add("8" + cur.get(i) + "8");
        }
        return res;
    }
}
