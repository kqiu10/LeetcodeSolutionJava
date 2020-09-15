package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _475_Heaters;
 * Creator: Kane;
 * Date: 9/3/20
 */

import com.sun.source.tree.Tree;

import java.lang.ref.Cleaner;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed
 * warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum
 * radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected
 * output will be the minimum radius standard of heaters.
 *
 * Note:
 *
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1
 * standard, then all the houses can be warmed.
 *
 * Time complexity:O(m * n);
 * Space complexity: O(1);
 * Description: sort
 */
public class _475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)){
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: Binary Search
 */

class HeatersII {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: TreeSet
 */

class HeatersIII {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for (int heater : heaters) {
            set.add(heater);
        }
        for (int house : houses) {
            int dist1 = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house) - house;
            int dist2 = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house);
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}



