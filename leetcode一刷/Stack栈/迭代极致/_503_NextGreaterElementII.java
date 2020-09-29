package Stack栈.迭代极致;
/**
 * Package Name : Stack栈.迭代极致;
 * File name : _503_NextGreaterElementII;
 * Creator: Kane;
 * Date: 8/26/20
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the
 * array), print the Next Greater Number for every element. The Next Greater Number of a number x
 * is the first greater number to its traversing-order next in the array, which means you could
 * search circularly to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: expand initial array to double size
 * Ex 1 2 1 -> 1 2 1 1 2 1 then use modular
 */
public class _503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return res;

    }
}
