package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : StringToInteger;
 * Creator: Kane;
 * Date: 7/21/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class StringToInteger8 {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int signal = 1;
        int start = 0;
        long res = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            signal = 1;
            start++;
        } else if (firstChar == '-') {
            signal = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)(res * signal);
            }
             res = res * 10 + (str.charAt(i) - '0');
            if (signal == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (signal == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return (int)(res * signal);

    }

    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }
}
