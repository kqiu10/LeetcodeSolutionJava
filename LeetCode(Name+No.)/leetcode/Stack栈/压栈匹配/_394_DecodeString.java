package Stack栈.压栈匹配;
/**
 * Package Name : Stack栈.压栈匹配;
 * File name : _394_DecodeString;
 * Creator: Kane;
 * Date: 8/25/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _394_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDight(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {

            }
        }

    }
}
