package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _248_StrobogrammaticNumberIII;
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
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <=
 * num <= high.
 *
 * Example:
 *
 * Input: low = "50", high = "100"
 * Output: 3
 * Explanation: 69, 88, and 96 are three strobogrammatic numbers.
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _248_StrobogrammaticNumberIII {
    public static int strobogrammaticInRange(String low, String high) {
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            list.addAll(helper(i,i));
        }
        for (String s : list) {
            if ( (s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                continue;
            }
            res++;
        }
        return res;

    }
    private static List<String> helper(int m, int n) {
        if (m == 0) return new ArrayList<>(Arrays.asList(""));
        if (m == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> cur = helper(m - 2, n);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.size(); i++) {
            if (m != n) {
                res.add("0" + cur.get(i) + "0");
            }
            res.add("6" + cur.get(i) + "9");
            res.add("9" + cur.get(i) + "6");
            res.add("1" + cur.get(i) + "1");
            res.add("8" + cur.get(i) + "8");


        }
        return res;
    }

    public static void main(String[] args) {
        strobogrammaticInRange("0", "0");
    }
}
