package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : MaxConsecutiveOnes485;
 * Creator: Kane;
 * Date: 8/8/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

}
