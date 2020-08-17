package ArrayList数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : MinimumIndexSumofTwoLists599;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O(n + m);
 * Space complexity: O(n);
 * Description:
 * list1.size() == n;
 * list2.size() == m;
 */
public class MinimumIndexSumofTwoLists599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && (i + j) <= min) {
                if (i + j < min) {
                    res.clear();
                    min = i + j;
                }
                res.add(list2[i]);
            }

        }
        return res.toArray(new String[res.size()]);

    }

    public static void main(String[] args) {
        String[] res = new String[]{"111", "222"};
        findRestaurant(res, res);
    }
}
