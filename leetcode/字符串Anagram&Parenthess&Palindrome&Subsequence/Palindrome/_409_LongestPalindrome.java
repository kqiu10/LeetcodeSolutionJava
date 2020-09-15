package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _409_LongestPalindrome;
 * Creator: Kane;
 * Date: 9/6/20
 */

import java.util.HashSet;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the
 * longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HaseSet
 */
public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        if (set.size() != 0) return count * 2 + 1;
        return count * 2;
    }
}


/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 */
class LongestPalindromeII{
    public int longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return 0;
        boolean bool = false;
        int res = 0;
        int[] count = new int[128];
        for (Character c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
                res++;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) bool = true;
        }
        if (bool) return res * 2 + 1;
        return res * 2;
    }
}
