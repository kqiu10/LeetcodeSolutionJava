package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : MinimumMovestoEqualArrayElementsII462;
 * Creator: Kane;
 * Date: 7/29/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class MinimumMovestoEqualArrayElementsII462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i <= j) {
            res += (nums[j--] - nums[i++]);
        }
        return res;

    }
}
