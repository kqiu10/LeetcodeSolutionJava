package src; /**
 * Date: 11/5/20
 * Question Description
 Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 Example 1:
 Input: nums = [1,1,2]
 Output:
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 Example 2:

 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n! * n);
 * Space complexity: O(n);

 */
public class _47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //i > 0 && nums[i] == nums[i - 1] 去重通用写法，&& !used[i - 1] 题目特有 也是为了去重
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, nums, used, list);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
