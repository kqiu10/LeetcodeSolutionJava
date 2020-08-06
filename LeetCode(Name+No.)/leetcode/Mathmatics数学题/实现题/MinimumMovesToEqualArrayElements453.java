package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : MinimumMovesToEqualArrayElements453;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: nums.length - 1个元素加一，相当于数组中的一个元素减1
 */
public class MinimumMovesToEqualArrayElements453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min,num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;


    }
}
/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: len * (min + k) = sum + k * (len - 1)
 *            =>k = sum - min * len;
 */
class MinimumMovesToEqualArrayElements453II{
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min,num);
        }
        int res = sum - min * nums.length;
        return res;


    }
}
