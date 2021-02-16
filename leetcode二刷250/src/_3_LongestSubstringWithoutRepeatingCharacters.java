/**
 * Date: 2/16/21
 * Question Description
 * Given a string s, find the length of the longest substring without repeating characters.
 * Examples:
 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 Example 4:

 Input: s = ""
 Output: 0
 */

import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
                i--;
            } else {
                set.add(s.charAt(i));
                maxlen = Math.max(maxlen, set.size());
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("aab");
    }

}
