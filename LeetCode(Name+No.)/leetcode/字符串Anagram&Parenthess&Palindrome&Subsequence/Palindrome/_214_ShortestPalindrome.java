package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _214_ShortestPalindrome;
 * Creator: Kane;
 * Date: 9/6/20
 */

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front
 * of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description:
 * Ex
 * Input: "abcd"
 * Output: "dcbabcd"
 *     i     j
 *     a b c d
 *           end
 *     j
 *     i
 *     a b c d
 *     end
 * end control the remaining string behind end
 *
 * edge case "a a a a a b c a a a a a" Time Complexity : O(n^2)
 */
public class _214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        // find the Palindrome String
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;

    }
}
