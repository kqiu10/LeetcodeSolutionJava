package leetcode.BitWise位运算;
/**
 * Description:
 * Round one
 * []
 * [1]
 * [1,2]
 * [1,2,3]
 * Round 2
 * [2]
 * [2,3]
 * Round 3
 * [3]
 * Package Name : leetcode.BitWise位运算;
 * File name : _78_Subsets;
 * Creator: Kane;
 * Date: 7/27/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(n*2^n);
 * Space complexity: O(n);
 */
public class _78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, 0);
        return res;

    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ArrayList<>());
        int[] test = new int[]{1,2,3};
        System.out.println(subsets(test));
    }
}
