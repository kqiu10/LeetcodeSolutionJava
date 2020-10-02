package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : _561_ArrayPartitionI;
 * Creator: Kane;
 * Date: 8/10/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
