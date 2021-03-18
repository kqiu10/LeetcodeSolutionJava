package src; /**
 * Date: 11/5/20
 * Question Description
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 */

/**
 * Description: TODO
 * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return null;
        int len1 = num1.length();
        int len2 = num2.length();
        int[] digits = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p = i + j;
                int q = i + j + 1;
                int sum = product + digits[q];
                digits[p] += sum / 10;
                digits[q] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && sb.length() == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
