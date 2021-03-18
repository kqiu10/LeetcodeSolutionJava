package src; /**
 * Date: 11/11/20
 * Question Description
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 The largest rectangle is shown in the shaded area, which has area = 10 unit.



 Example:

 Input: [2,1,5,6,2,3]
 Output: 10
 */

import java.util.Stack;

/**
 * Description:
 Ex     0   1  2  3  4  5  6
        [2, 1, 5, 6, 2, 3, 0]


 stack : 2: push
         1 : height = 2, start = -1, area = 2   stack: 1
         5 : push   stack 1, 2
         6 : push   stack 1, 2, 3
         2(i = 4) : height = 6, start = 2, area = 6
           : height = 5, start = 1, area = 5 * 2 = 10
         stack  1, 2
         3 :  stack 1, 2, 3
         0 :  height = 3 start = 4 area = 3
              height = 2 start = 3 area = 4
              height = 1 start = -1 area = 6

 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
