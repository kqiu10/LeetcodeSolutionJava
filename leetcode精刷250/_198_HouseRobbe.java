/**
 * Date: 11/21/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();n
 * Space complexity: O(1);

 */
public class _198_HouseRobbe {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int preNo = 0;
        int curYes = 0;
        for (int num : nums) {
            int temp = preNo;
            preNo = Math.max(preNo, curYes);
            curYes = temp + num;
        }
        return Math.max(curYes, preNo);
    }
}
