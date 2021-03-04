/**
 * Date: 3/4/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        int maxNext = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxNext < i) return false;
            maxNext = Math.max(i + nums[i], maxNext);
        }
        return true;
    }
}
