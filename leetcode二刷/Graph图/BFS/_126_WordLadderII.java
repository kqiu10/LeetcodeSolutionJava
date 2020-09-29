package leetcode.Graph图.BFS;
/**
 * Date: 9/22/20
 * Question Description
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
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
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;

        HashSet<String> unvisited = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        int curNum = 1;
        int nextNum = 0;
        boolean found = false;

        HashMap<String, List<String>> map = new HashMap<>();

        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (unvisited.contains(temp)) {
                        if (visited.add(temp)) {
                            nextNum++;
                            queue.offer(temp);
                        }
                        if (map.containsKey(temp)) {
                            map.get(temp).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(temp, list);
                        }
                        if (temp.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (curNum == 0) {
                if (found == true) break;
                curNum = nextNum;
                nextNum = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        dfs(res, new ArrayList<>(), map, endWord, beginWord);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> list, HashMap<String, List<String>> map, String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
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

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

}
