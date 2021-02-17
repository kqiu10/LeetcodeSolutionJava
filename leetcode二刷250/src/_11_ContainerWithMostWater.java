/**
 * Date: 2/17/21
 * Question Description
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai)
 * and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the
 * container contains the most water.
 *
 * Notice that you may not slant the container.
 * Examples:
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 * Example 3:
 *
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * Example 4:
 *
 * Input: height = [1,2,1]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            if (cur > res) {
                res = cur;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
