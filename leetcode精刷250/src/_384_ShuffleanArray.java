package src; /**
 * Date: 12/11/20
 * Question Description
 Given an integer array nums, design an algorithm to randomly shuffle the array.

 Implement the Solution class:

 Solution(int[] nums) Initializes the object with the integer array nums.
 int[] reset() Resets the array to its original configuration and returns it.
 int[] shuffle() Returns a random shuffling of the array.


 Example 1:

 Input
 ["Solution", "shuffle", "reset", "shuffle"]
 [[[1, 2, 3]], [], [], []]
 Output
 [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

 Explanation
 Solution solution = new Solution([1, 2, 3]);
 solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
 solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */

import java.util.Random;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _384_ShuffleanArray {
    Random rnd;
    int[] nums;
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
        int[] copy = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            int random = rnd.nextInt(i + 1);
            swap(copy, i, random);
        }
        return copy;

    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
