package Stack栈.迭代极致;
/**
 * Package Name : Stack栈.迭代极致;
 * File name : _42_TrappingRainWater;
 * Creator: Kane;
 * Date: 8/26/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _42_TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int right = height.length - 1;
        int left = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
