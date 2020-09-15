package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : ShuffleanArray384;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.Random;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _384_ShuffleanArray {
    int[] nums;
    Random rnd;

    public _384_ShuffleanArray(int[] nums) {
        this.nums = nums;
        rnd = new Random();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] clone = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            int random = rnd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;

    }
    private  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _384_ShuffleanArray test = new _384_ShuffleanArray(new int[]{1,2 ,3});
        test.shuffle();
    }
}
