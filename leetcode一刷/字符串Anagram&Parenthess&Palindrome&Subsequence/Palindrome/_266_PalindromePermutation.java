package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _266_PalindromePermutation;
 * Creator: Kane;
 * Date: 9/6/20
 */

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int[] count = new int[128];
        int sole = 0;
        for (Character c : s.toCharArray()) {
            if (count[c] == 0) {
                count[c]++;
            } else {
                count[c]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sole++;
            }
        }
        return sole <= 1;
    }
}
