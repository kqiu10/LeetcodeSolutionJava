package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : LongestIncreasingSubsequence300;
 * Creator: Kane;
 * Date: 7/19/20
 */

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class LongestIncreasingSubsequence300 {
    public static int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int size = 0;
        for (int num: nums) {
            int i = 0, j = size;
            while(i != j) {
                int mid = (i + j) / 2;
                if(res[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            res[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
