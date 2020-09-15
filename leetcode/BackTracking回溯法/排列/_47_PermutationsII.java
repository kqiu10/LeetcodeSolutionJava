package leetcode.BackTracking回溯法.排列;
/**
 * Package Name : leetcode.BackTracking回溯法;
 * File name : _47_PermutationsII;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique
 * permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * Time complexity:O(n!);
 * Space complexity: O(n);
 * Description: backTrack
 */
public class _47_PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;

    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

/**
 * Time complexity:O(n!);
 * Space complexity: O(n);
 * Description: backTrack
 *
 */
