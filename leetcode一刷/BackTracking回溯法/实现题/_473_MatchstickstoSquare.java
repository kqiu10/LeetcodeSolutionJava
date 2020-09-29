package leetcode.BackTracking回溯法.实现题;
/**
 * Date: 9/18/20
 * Question Description
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little
 * match girl has, please find out a way you can make one square by using up all those
 * matchsticks. You should not break any stick, but you can link them up, and each matchstick
 * must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has, represented with their stick length. Your
 * output will either be true or false, to represent whether you could make one square using all
 * the matchsticks the little match girl has.
 *
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with
 * length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 *
 */

/**
 *
 * Time complexity:O(4^n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _473_MatchstickstoSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        return helper(nums, nums.length - 1, sum / 4, new int[4]);

    }
    private boolean helper(int[] nums, int index, int side, int[] sides) {
        if (index < 0) {
            return (sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side);
        }
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + nums[index] > side) continue;
            sides[i] += nums[index];
            if (helper(nums, index - 1, side, sides)) {
                return true;
            }
            sides[i] -= nums[index];
        }
        return false;
    }
}
