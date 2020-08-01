package 数组.bucketSort;
/**
 * Package Name : leetcode.数组;
 * File name : MaximumGap164;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * 1 3 5 9
 * min = 1;
 * max = 9
 * gap = 3
 * 1 -> 9 均匀分配: 1 4 7 9;
 * bucketMin 3 5 INF;
 * bucketMax 3 5 -INF;
 * 共三个bucket，计算bucket中的最小值与上一个bucket最大值的差值,找出最大的差值为答案.
 */
public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] bucketMin = new int[len - 1];
        int[] bucketMax = new int[len - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int bucket = (num - min) / gap;
            bucketMin[bucket] = Math.min(num, bucketMin[bucket]);
            bucketMax[bucket] = Math.max(num, bucketMax[bucket]);
        }
        int res = 0;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE || bucketMax[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        return Math.max(res, max - pre);
    }
}
