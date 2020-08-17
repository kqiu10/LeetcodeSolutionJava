package ArrayList数组.单向双指针;
/**
 * Package Name : 数组.单向双指针;
 * File name : MaxConsecutiveOnesII487;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: 对任意k的情况
 */
public class MaxConsecutiveOnesII487 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int k = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.offer(i);
            }
            if (queue.size() > k) {
                l = queue.poll() + 1;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;


    }

    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
    }
}
