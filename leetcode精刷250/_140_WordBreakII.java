/**
 * Date: 11/16/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
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
 *              end : 3 -> dfs
 *                  start : 3 map : 3 empty - > "sand dog"
 *                      end : 4 -> dfs
 *                          start : 4 map : 4 "and dog"
 *                              end : 7 -> dfs
 *                                  start : 7 map : 7 empty -> "dog"
 *                                       start = 0 res : "cat sand dog" "cats and dog";
 */

public class _140_WordBreakII {
    public static HashMap<Integer, List<String>> map = new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);

    }
    private static List<String> dfs(String s, List<String> words, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (words.contains(s.substring(start, end))) {
                List<String> list = dfs(s, words, end);
                System.out.println("list size" + list.size() + "what is list" + list.toString());
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
    }
}
