package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : AddStrings415;
 * Creator: Kane;
 * Date: 7/25/20
 */

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Time complexity:O(n + m);
 * Space complexity: O(n);
 */
public class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int curry = 0;
        int a;
        int b;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || curry == 1) {
            a = i>= 0 ? num1.charAt(i--) -'0' : 0;
            b = j>= 0 ? num2.charAt(j--) -'0' : 0;
            int sum = a + b + curry;
            sb.append(sum % 10);
            curry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
