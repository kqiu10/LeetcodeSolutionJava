package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _163_MissingRanges;
 * Creator: Kane;
 * Date: 9/3/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range
 * [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * Edge Case
 * [2147483647] 0 214748367
 * ["0 -> 214748366"]
 * ["0 -> 214748366", "-2147483648 -> 2147483647"]
 *
 */
public class _163_MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long)lower, aupper = (long)upper;
        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num -1));
                }
                alower = (long)num + 1;
            }
        }
        if (alower == aupper) res.add(String.valueOf(alower));
        else if (alower < aupper) res.add(alower + "->"+  aupper);
        return res;
    }

    public static void main(String[] args) {
        findMissingRanges(new int[]{0, 1, 3, 50, 97}, 0, 99);
    }
}
