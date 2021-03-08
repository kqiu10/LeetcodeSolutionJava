/**
 * Date: 3/8/21
 * Question Description:
 * A valid number can be split up into these components (in order):
 *
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * At least one digit, followed by a dot '.'.
 * At least one digit, followed by a dot '.', followed by at least one digit.
 * A dot '.', followed by at least one digit.
 * An integer can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * At least one digit.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9",
 * "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not
 * valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: s = "0"
 * Output: true
 * Example 2:
 *
 * Input: s = "e"
 * Output: false
 * Example 3:
 *
 * Input: s = "."
 * Output: false
 * Example 4:
 *
 * Input: s = ".1"
 * Output: true
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _65_ValidNumber {
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
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (eSeen ||!numberSeen) return false;
                eSeen = true;
                numberAfterE = false;
            }else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && (s.charAt(i - 1) != 'e')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
