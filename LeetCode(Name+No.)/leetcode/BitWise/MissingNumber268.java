package leetcode.BitWise;
/**
 * Description: TODO
 * Package Name : leetcode.位运算;
 * File name : MissingNumber268;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];

        }
        return res;

    }
}
