package HashMap;
/**
 * Package Name : HashMap;
 * File name : _3_LongestSubstringWithoutRepeatingCharacters;
 * Creator: Kane;
 * Date: 9/2/20
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HashMap
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


}
/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HashSet
 */
class lengthOfLongestSubstringII {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i =0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
                i--;
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;

    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcbc");
    }
}


