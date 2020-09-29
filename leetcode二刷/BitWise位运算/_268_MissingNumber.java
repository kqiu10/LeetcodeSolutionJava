package leetcode二刷.BitWise位运算;
/**
 * Description: TODO
 * Package Name : leetcode.位运算;
 * File name : _268_MissingNumber;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];

        }
        return res;

    }
}
