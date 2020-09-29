/**
 * Package Name : PACKAGE_NAME;
 * File name : _198_HouseRobber;
 * Creator: Kane;
 * Date: 9/10/20
 */

/**
 * Time complexity:O(n);
 * Space complexnity: O(1);
 * Description: TODO
 */
public class _198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prevMax = 0;
        int curMax = 0;
        for (int x : nums) {
            int temp = prevMax;
            curMax = Math.max(curMax, prevMax + x);
            prevMax = temp;
        }
        return curMax;

    }
}
