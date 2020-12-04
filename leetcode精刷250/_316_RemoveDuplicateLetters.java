/**
 * Date: 12/3/20
 * Question Description
 Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 Example 1:

 Input: s = "bcabc"
 Output: "abc"
 Example 2:

 Input: s = "cbacdcbc"
 Output: "acdb"
 */

import java.util.HashMap;

/**
 * Description: TODO
 * Time complexity:O(len(distinct number));
 * Space complexity: O(m);

 */
public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMin(map);
        for (int i = 0; i < res.length; i++) {
            char cur = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < cur) {
                    cur = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = cur;
            map.remove(cur);
            if (s.charAt(end) == cur) {
                end = findMin(map);
            }

        }
        return new String(res);
    }

    private int findMin(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int val : map.values()) {
            res = Math.min(res, val);
        }
        return res;
    }
}
