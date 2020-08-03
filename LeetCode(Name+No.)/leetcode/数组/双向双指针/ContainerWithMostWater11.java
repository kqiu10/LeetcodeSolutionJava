package 数组.双向双指针;
/**
 * Package Name : 数组.双向双指针;
 * File name : ContainerWithMostWater11;
 * Creator: Kane;
 * Date: 8/3/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
