/**
 * Date: 11/2/20
 * Question Description
 */

import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
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
}
