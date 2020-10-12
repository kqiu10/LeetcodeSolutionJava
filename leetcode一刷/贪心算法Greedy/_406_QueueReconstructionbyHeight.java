package 贪心算法Greedy;
/**
 * Package Name : 数组.全排序;
 * File name : _406_QueueReconstructionbyHeight;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _406_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <=1) return people;
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
