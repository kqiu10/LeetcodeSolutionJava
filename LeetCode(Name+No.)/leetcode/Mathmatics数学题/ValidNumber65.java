package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : ValidNumber65;
 * Creator: Kane;
 * Date: 7/29/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: edge case
 * e只能在点的后面
 * e后面可以接正负号
 * e后面不可以不接字母
 * e前必须带字母
 * 一个字符串只能出现一个e
 * "2e10" => true;
 * "2e" => false;
 * "2e-5" => true;
 * "2e+10" => true;
 * "e." => false;
 * ".1e0" => true
 */
public class ValidNumber65 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean numberAfterE = true;
        boolean eSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;

            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false;

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && (s.charAt(i - 1) != 'e')) return false;
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;

    }
}
