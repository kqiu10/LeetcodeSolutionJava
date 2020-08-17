package leetcode.数组;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : IncreasingTripletSubsequence334;
 * Creator: Kane;
 * Date: 7/19/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1;
 */
public class IncreasingTripletSubsequence334 {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            throw new IndexOutOfBoundsException();
        }
        int min = Integer.MAX_VALUE, minSecond = Integer.MAX_VALUE;
        for(int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < minSecond) {
                minSecond = num;
            } else if (num > minSecond) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,2,1,4}));
    }
}
