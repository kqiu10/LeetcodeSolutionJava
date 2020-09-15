package src.shape.Triangle;
/**
 * Package Name : src.shape.Triangle;
 * File name : Triangle;
 * Creator: Kane;
 * Date: 9/14/20
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Triangle {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] <= nums[i]) {
                    start++;
                    continue;
                }
                res += (end - start);
                end--;
            }
        }
        return res;
    }
}
