/**
 * Date: 11/3/20
 * Question Description
 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Notice that the solution set must not contain duplicate quadruplets.

 Example 1:

 Input: nums = [1,0,-1,0,-2,2], target = 0
 Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 Example 2:

 Input: nums = [], target = 0
 Output: []
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n ^ 3);
 * Space complexity: O(n^2);

 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int sum = target - nums[i] - nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (sum == nums[l] + nums[r]) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }

            }
        }
        return res;
    }
}
