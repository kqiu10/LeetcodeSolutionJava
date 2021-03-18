package src; /**
 * Date: 11/22/20
 * Question Description
 Given a string s, you can convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.



 Example 1:

 Input: s = "aacecaaa"
 Output: "aaacecaaa"
 Example 2:

 Input: s = "abcd"
 Output: "dcbabcd"
 */

/**
 * Description:
 * end 用于记录新的palindrome开始的位置
 * Time complexity:O(n ^ 2);
 * Space complexity: O(1);

 */
public class _214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
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
