package 设计题.HashMap;
/**
 * Date: 10/18/20
 * Question Description
 Design a class which receives a list of words in the constructor,
 and implements a method that takes two words word1 and word2 and
 return the shortest distance between these two words in the list.
 Your method will be called repeatedly many times with different parameters.
 Example:
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Input: word1 = “coding”, word2 = “practice”
 Output: 3
 Input: word1 = "makes", word2 = "coding"
 Output: 1
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:

 * Time complexity:O(n);
 * Space complexity: O(n + m);

 */
public class _244_ShortestWordDistanceII {
    HashMap<String, List<Integer>> map;
    public _244_ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<Integer>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int l1 = 0, l2 = 0, res = Integer.MAX_VALUE;
        while (l1 < list1.size() && l2 < list2.size()) {
            res = Math.min(res, Math.abs(list1.get(l1) - list2.get(l2)));
            if (list1.get(l1) < list2.get(l2)) {
                l1++;
            } else{
                l2++;
            }
        }
        return res;
    }
}
