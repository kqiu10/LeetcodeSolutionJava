package 数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : ThreeSum3;
 * Creator: Kane;
 * Date: 8/5/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            int sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) l++;
                else r--;
            }
        }
        return res;
    }
}
