package leetcode.数组;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : _334_IncreasingTripletSubsequence;
 * Creator: Kane;
 * Date: 7/19/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1;
 */
public class _334_IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            throw new IndexOutOfBoundsException();
        }
        int smallOne = Integer.MAX_VALUE, smallTwo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= smallOne) {
                smallOne = nums[i];
            } else if (nums[i] <= smallTwo) {
                smallTwo = nums[i];
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,2,1,4}));
    }
}
