package ArrayList数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : BrickWall554;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.HashMap;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class BrickWall554 {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
       for (List<Integer> row : wall) {
           int sum = 0;
           for (int i = 0; i < row.size() - 1; i++) {
               sum += row.get(i);
               map.put(sum, map.getOrDefault(sum, 0) + 1);
           }
       }
       int max = 0;
       for (int count : map.values()) {
           max = Math.max(max,count);
       }
       return wall.size() - max;

    }
}
