/**
 * Date: 11/28/20
 * Question Description
 There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.

 You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.

 Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.

 Example 1:

 Input: words = ["wrt","wrf","er","ett","rftt"]
 Output: "wertf"
 Example 2:

 Input: words = ["z","x"]
 Output: "zx"
 Example 3:

 Input: words = ["z","x","z"]
 Output: ""
 Explanation: The order is invalid, so return "".
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _269_AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        int degree[] = new int[26];
        int count = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    degree[c - 'a'] = 1;
                    count++;
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
                queue.offer((char)(i + 'a'));
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                for (char next : map.get(c)) {
                    if (--degree[next - 'a'] == 1) {
                        queue.offer(next);
                    }
                }
            }

        }
        return sb.length() == count ? sb.toString() : "";
    }

}
