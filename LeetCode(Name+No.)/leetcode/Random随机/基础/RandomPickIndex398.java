package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : RandomPickIndex398;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.Random;

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class RandomPickIndex398 {
    int[] nums;
    Random rnd;

    public RandomPickIndex398(int[] nums) {
        this.nums = nums;
        rnd = new Random();

    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rnd.nextInt(++count) == 0) {
                res = i;
            }

        }
        return res;

    }
}
