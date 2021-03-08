/**
 * Date: 3/8/21
 * Question Description:
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

/**
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(1)
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        while (len1 >= 0 || len2 >= 0) {
            int cur = reminder;
            if (len1 >= 0) {
                cur += a.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                cur += b.charAt(len2--) - '0';
            }
            sb.append(cur % 2);
            reminder = cur / 2;
        }
        if (reminder == 1) {
            sb.append(reminder);
        }
        return sb.reverse().toString();
    }
}
