/**
 * Date: 11/5/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n!);
 * Space complexity: O(n);

 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper (res, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(res, nums, index + 1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
