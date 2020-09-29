package ArrayList数组.HashSet;
/**
 * Package Name : 数组.HashSet;
 * File name : _575_DistributeCandies;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashSet;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
