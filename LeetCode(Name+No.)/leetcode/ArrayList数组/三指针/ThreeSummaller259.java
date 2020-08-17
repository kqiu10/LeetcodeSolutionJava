package ArrayList数组.三指针;
/**
 * Package Name : 数组.三指针;
 * File name : ThreeSummaller259;
 * Creator: Kane;
 * Date: 8/5/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class ThreeSummaller259 {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    res += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
