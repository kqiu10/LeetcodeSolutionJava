package src; /**
 * Date: 11/19/20
 * Question Description
 You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

 A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

 Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

 Each range [a,b] in the list should be output as:

 "a->b" if a != b
 "a" if a == b
 Example 1:

 Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 Output: ["2","4->49","51->74","76->99"]
 Explanation: The ranges are:
 [2,2] --> "2"
 [4,49] --> "4->49"
 [51,74] --> "51->74"
 [76,99] --> "76->99"
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long)lower, aupper = (long)upper;
        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    String cur = alower + "->" + (num - 1);
                    res.add(cur);
                }
                alower = num + 1;
            }
        }
        if (alower < aupper) {
            String cur = alower + "->" + aupper;
            res.add(cur);
        }
        if (alower == aupper) {
            res.add(String.valueOf(alower));
        }
        return res;
    }
}
