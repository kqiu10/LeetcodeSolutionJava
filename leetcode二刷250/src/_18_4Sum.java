/**
 * Date: 2/18/21
 * Question Description:
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
 * nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives
 * the sum of target.
 *
 * Notice that the solution set must not contain duplicate quadruplets.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [], target = 0
 * Output: []
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n^3)
 * Space Complexity: O(1)
 */
public class _18_4Sum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 4) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int left = j + 1;
                    int right = nums.length - 1;
                    int remain = target - nums[i] - nums[j];
                    while (left < right) {
                        if (nums[left] + nums[right] == remain) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right &&nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;
                        } else if (nums[left] + nums[right] < remain) {
                            left++;
                        } else {
                            right --;
                        }
                    }
                }
            }
            return res;
        }
}
