package src; /**
 * Date: 12/12/20
 * Question Description
 Given an encoded string, return its decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



 Example 1:

 Input: s = "3[a]2[bc]"
 Output: "aaabcbc"
 Example 2:

 Input: s = "3[a2[c]]"
 Output: "accaccacc"
 Example 3:

 Input: s = "2[abc]3[cd]ef"
 Output: "abcabccdcdcdef"
 Example 4:

 Input: s = "abc3[cd]xyz"
 Output: "abccdcdcdxyz"
 */

import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _394_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        Stack<Integer> count = new Stack<>();
        Stack<String> ele = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                count.push(num);
            } else if (s.charAt(idx) == '[') {
                ele.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(ele.pop());
                int frequent = count.pop();
                for (int i = 0; i < frequent; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
