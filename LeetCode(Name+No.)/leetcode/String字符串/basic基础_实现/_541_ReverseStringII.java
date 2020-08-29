package String字符串.basic基础_实现;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _541_ReverseStringII;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k
 * characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters, then
 * reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _541_ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s.length() == 0 || s == null) return s;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            int start = i, end = Math.min(i + k - 1, str.length - 1);
            while (start < end) {
                char temp = str[start];
                str[start++] = str[end];
                str[end--] = temp;

            }
        }
        return new String(str);
    }
}
