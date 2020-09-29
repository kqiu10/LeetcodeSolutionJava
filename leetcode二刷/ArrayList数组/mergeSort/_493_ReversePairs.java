package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : _493_ReversePairs;
 * Creator: Kane;
 * Date: 7/29/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description:
 * k 是 merge[]数组的index;
 * p 是 mergeSort右边数组的index;
 * i 是 mergeSort左边数组的index;
 * j 是 mergeSort右边数组的index;
 * 有关前后顺序使用MergeSort
 * Similar questions
 * 315. Count of Smaller Numbers After Self
 * 327. Count of Range Sum
 */
public class _493_ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSortHelper(nums, 0 , nums.length - 1);
    }
    private static int mergeSortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) / 2);
        int res = mergeSortHelper(nums, left, mid) + mergeSortHelper(nums, mid + 1, right);
        int i = left, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[right - left + 1];
        while (i <= mid) {
            //2L代表强制把int型转换成long型,避免越界
            while (p <= right && nums[i] > 2L * nums[p]) {
                p++;
            }
            res += (p - (mid + 1));
            //先判断是否要添加右边数组的元素,但每轮都需要添加左边数组的一个元素
            while (j <= right && nums[i] >= nums[j]) {
                merge[k++] = nums[j++];
            }
            merge[k++] = nums[i++];
        }
        while (j <= right) {
            merge[k++] = nums[j++];
        }
        System.arraycopy(merge, 0, nums, left, merge.length);
        System.out.println("nums is + " + Arrays.toString(nums));
        return res;
    }

    public static void main(String[] args) {
        reversePairs(new int[]{1,3,2,3,1});

    }
}
