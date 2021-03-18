package src; /**
 * Date: 11/26/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

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
        int res  = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int l1 = 0, l2 = 0;
        while (l1 < list1.size() && l2 < list2.size()) {
            res = Math.min(res, Math.abs(list1.get(l1) - list2.get(l2)));
            if (list1.get(l1) < list2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return res;
    }
}
