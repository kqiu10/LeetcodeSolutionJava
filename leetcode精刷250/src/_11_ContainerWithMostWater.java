package src; /**
 * Date: 11/2/20
 * Question Description
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

 Notice that you may not slant the container.



 Example 1:


 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49
 Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        if (height == null || height.length == 0) return 0;
        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, cur);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;

    }

}
