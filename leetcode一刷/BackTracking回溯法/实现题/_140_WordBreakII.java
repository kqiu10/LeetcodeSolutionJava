package leetcode.BackTracking回溯法.实现题;
/**
 * Date: 9/16/20
 * Question Description
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add
 * spaces in s to construct a sentence where each word is a valid dictionary word. Return all
 * such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time complexity:O(n^3);
 * Space complexity: O(n^3);
 * Description:DFS
 * Ex:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 *
 *          c a t s a n d d o g
 *          0 1 2 3 4 5 6 7 8 9
 *          start : 0  map : empty
 *          end : 3 -> dfs
 *                  start : 3 map : 3 empty - > "sand dog"
 *          end : 4 -> dfs
 *                  start : 4 map : 4 "and dog"
 *              end : 7 -> dfs
 *                    start : 7 map : 7 empty -> "dog"
 *         start = 0 res : "cat sand dog" "cats and dog";
 */
public class _140_WordBreakII {
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);

    }
    public List<String> dfs (String s, List<String> wordDictm, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDictm.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDictm, end);
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
