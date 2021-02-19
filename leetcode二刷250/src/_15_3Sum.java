/**
 * Date: 2/18/21
 * Question Description:
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Notice that the solution set must not contain duplicate triplets.


 * Examples:
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 2) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int rest = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == rest) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < rest) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

}
