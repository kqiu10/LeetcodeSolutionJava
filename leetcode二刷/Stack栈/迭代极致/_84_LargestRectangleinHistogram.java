package Stack栈.迭代极致;
/**
 * Package Name : Stack栈.迭代极致;
 * File name : _84_LargestRectangleinHistogram;
 * Creator: Kane;
 * Date: 8/26/20
 */

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each
 * bar is 1, find the area of largest rectangle in the histogram.

 * this is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * Ex [2, 1, 5, 6, 2, 3]
 * stack 1.升序， 2， 小于， 计算
 * stack:
 * 2 : push
 * 1 : height = 2 start = -1 area = 2;
 * 5 : push
 * 6 : push
 * 2 : height = 6 start = 2 area = 6
 *     height = 5 start = 1 area = 10
 * 3 : push
 * 0 : height = 3 start = 4 area = 6
 *     height = 2 start = 1 area = 8
 *   : height = 1 start = -1 area = 6
 */
public class _84_LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
       if (heights == null || heights.length == 0) return 0;
       Stack<Integer> stack = new Stack<>();
       int res = 0;
       for (int i = 0; i <= heights.length; i++) {
           int h = i == heights.length ? 0 : heights[i];
           while (!stack.isEmpty() && h < heights[stack.peek()]) {
               int height = heights[stack.pop()];
               int start = stack.isEmpty() ? -1 : stack.peek();
               int area = height * (i - start - 1);
               res = Math.max(area, res);
           }
           stack.push(i);
       }
       return res;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});

    }
}
