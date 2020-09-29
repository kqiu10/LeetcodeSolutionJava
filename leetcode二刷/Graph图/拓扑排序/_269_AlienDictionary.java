package leetcode.Graph图.拓扑排序;
/**
 * Date: 9/23/20
 * Question Description
 * There is a new alien language which uses the latin alphabet. However, the order among letters
 * are unknown to you. You receive a list of non-empty words from the dictionary, where words are
 * sorted lexicographically by the rules of this new language. Derive the order of letters in
 * this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O(V + E);
 * Space complexity: O(n);
 * Description:
 * 图 -> 入度为0 -> BFS
 * Ex
 * degree :
 * w : 1
 * e : 2
 * r : 2
 * t : 2
 * f : 2
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * map : t, f
 *       w, e
 *       r, t
 *       e, r
 * w - e - r - t - f
 */
public class _269_AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int count = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] ++;
                }
             }
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {return "";}
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {
                        degree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.offer((char)('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            if (map.containsKey(cur)) {
                for (char ch : map.get(cur)) {
                    if (--degree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }

        }
    return res.length() == count ? res.toString() : "";
    }
}
