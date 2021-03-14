import java.util.Arrays;
import java.util.Stack;

/**
 * Date: 11/11/20
 * Question Description
 Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example 1:

 Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 Output: 6
 Explanation: The maximal rectangle is shown in the above picture.
 Example 2:

 Input: matrix = []
 Output: 0
 Example 3:

 Input: matrix = [["0"]]
 Output: 0
 Example 4:

 Input: matrix = [["1"]]
 Output: 1
 Example 5:

 Input: matrix = [["0","0"]]
 Output: 0
 */


public class _85_MaximalRectangle {
    /**
     * Description: DP
      left[] :从左到右， 出现连续'1'的string的第一个坐标
      right[] : 从右到左， 出现连续'1'的string的最后一个坐标
      height[] 从上到下的高度
      res = (right[j] - left[j]) * heights[j]
     * Time complexity:O(m * n);
     * Space complexity: O(n);
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curLeft, left[j]);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    /**
     * Description: Stack
       Stack : Index 永远升序
     * Time complexity:O(m * n);
     * Space complexity: O(n);
     */
    public int maximalRectangleII(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n] = 0;
        int res = 0;

        for (int row = 0; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n + 1; i++) {
                if (i < n) {
                    if (matrix[row][i] == '1') {
                        height[i]++;
                    } else {
                        height[i] = 0;
                    }
                }
                if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                        int cur = height[stack.pop()] * (stack.isEmpty() ? i :
                                (i - stack.peek() - 1));
                        res = Math.max(res, cur);
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
