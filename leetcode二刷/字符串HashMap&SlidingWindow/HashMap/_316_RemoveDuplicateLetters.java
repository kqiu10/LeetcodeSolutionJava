package HashMap;
/**
 * Package Name : HashMap;
 * File name : _316_RemoveDuplicateLetters;
 * Creator: Kane;
 * Date: 9/3/20
 */

import java.util.HashMap;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every
 * letter appears once and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *

 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 * Input: "cbacdcbc"
 * Output: "acdb"
 * c b a c d c b c
 * 0 1 2 3 4 5 6 7
 * map : a 2
 *       c 7
 *       d 4
 *       b 6
 *iteration sequence
 *
 * cba start = 0, end = 2 a
 * cd  start = 3, end = 4 c
 * d   start = 4, end = 4 d
 * b   start = 6, end = 6 b
 * return acdb
 *
 */
public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMinLastPos(map);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(map);
            }
        }

        return new String(res);

    }
    public int findMinLastPos(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int val : map.values()) {
            res = Math.min(res, val);
        }
        return res;
    }
}
