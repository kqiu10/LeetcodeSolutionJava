package ArrayList数组.三指针;
/**
 * Package Name : 数组.三指针;
 * File name : ShortestUnsortedContinuousSubarray581;
 * Creator: Kane;
 * Date: 8/7/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * find min from right to left, and find max from left to right.
 */
public class ShortestUnsortedContinuousSubarray581 {
    public static  int findUnsortedSubarray(int[] nums) {
        int l = - 1;
        int r = -1;
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, nums[len - 1 - i]);
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                r = i;
            }
            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            }
        }
        System.out.println("l is " + l + "r is " + r);
        return (l == -1 && r == -1) ? 0 : r - l + 1;

    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 6, 4 ,8 ,10, 9 ,15};
        int[] test2 = new int[]{1, 2, 3, 4};
        findUnsortedSubarray(test2);
    }
}
