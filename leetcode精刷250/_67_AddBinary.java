/**
 * Date: 11/7/20
 * Question Description
 Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        while (len1 >= 0 || len2 >= 0) {
            int res = reminder;
            if (len1 >= 0) {
                res += a.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                res += b.charAt(len2--) - '0';
            }
            sb.append(res % 2);
            reminder = res / 2;
        }
        if (reminder != 0 ) {
            sb.append(reminder);
        }
        return sb.reverse().toString();
    }
}
