/**
 * Date: 11/14/20
 * Question Description
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output:
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */

import java.util.*;

/**
 * Time complexity:O(V + E) * wordList(max(length));
 * Space complexity: O(n);
 *
 *
 * Description: BFS + DFS
 * 无向图 -> BFS -> 树 -> DFS -> 结果
 *
 * Ex
 *      beginWord = "hit",
 *      endWord = "cog",
 *      wordList = ["hot","dot","dog","lot","log","cog"]
 *      hit -> hot -> dot -> dog -> cog
 *                 -> lot -> log -> cog
 *
 *      map : hot(hit)
 *            dot(hot)
 *            lot(hot)
 *            dog(dot)
 *            log(lot)
 *            cog(dog, log)
 */
public class _126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(wordList);

        HashMap<String, List<String>> map = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        int curCount = 1;
        int nextCount = 0;
        boolean find = false;

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            curCount--;
            for (int i = 0; i < cur.length(); i++) {
                char[] curChars = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curChars[i] = c;
                    String curStr = new String(curChars);
                    if (unvisited.contains(curStr)) {
                        if (visited.add(curStr)) {
                            queue.offer(curStr);
                            nextCount++;
                        }
                        if (map.containsKey(curStr)) {
                            map.get(curStr).add(cur);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(cur);
                            map.put(curStr, list);
                        }
                        if (curStr.equals(endWord)) {
                            find = true;
                        }
                    }
                }
            }
            if (curCount == 0) {
                if (find == true) break;
                curCount = nextCount;
                nextCount = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        dfs(res, new LinkedList<>(), map, endWord, beginWord);
        return res;
    }
    private void dfs(List<List<String>> res, LinkedList<String> list, HashMap<String, List<String>> map, String word, String start) {
        if (word == start) {
            list.add(0, word);
            res.add(new LinkedList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, start);
            }
        }
        list.remove(0);
    }

}
