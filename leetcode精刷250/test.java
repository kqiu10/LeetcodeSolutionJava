/**
 * Date: 11/23/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class test {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {return 0;}
        s = s.trim().replaceAll("\\s+", "");
        int res = 0;
        int preVal = 0;
        int i = 0;
        char signal = '+';
        while ( i < s.length()) {
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (signal == '+') {
                res += preVal;
                preVal = curVal;
            } else if (signal == '-') {
                res += preVal;
                preVal = -curVal;
            } else if (signal == '*') {
                preVal = preVal * curVal;
            } else if (signal == '/') {
                preVal = preVal / curVal;
            }
            if (i < s.length()) {
                signal = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
