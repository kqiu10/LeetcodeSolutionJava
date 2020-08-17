package ArrayList数组.双向双指针;
/**
 * Package Name : 数组.双向双指针;
 * File name : ThreeSumCloset;
 * Creator: Kane;
 * Date: 8/5/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class ThreeSumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            int sum;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }

        }
        return res;
    }
}
