/**
 * Date: 11/14/20
 * Question Description
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        int curCount = 1;
        int nextCount = 0;
        int level = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            curCount--;
            for (int i = 0; i < cur.length(); i++) {
                char[] curChars =  cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curChars[i] = c;
                    String trans = new String(curChars);
                    if (set.contains(trans)) {
                        if (trans.equals(endWord)) {
                            return level + 1;
                        }
                        queue.offer(trans);
                        nextCount++;
                        set.remove(trans);
                    }
                }
            }
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                level++;
            }
        }
        return 0;
    }
}
