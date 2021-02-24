package sortAlgorithm;
/**
 * Package Name : sortAlgorithm;
 * File name : HeapSort;
 * Creator: Kane;
 * Date: 9/11/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(nlogn);
 * Description: TODO
 */
public class HeapSort {
    public static void HeapSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i );
            heapAdjust(nums, 0, i);
        }
    }
    private static void heapAdjust(int[] nums, int start, int length) {
        int child = 2 * start + 1;
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[start] < nums[child]) {
                int temp = nums[start];
                nums[start] = nums[child];
                nums[child] = temp;
            } else {
                break;
            }
            start = child;
        }
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 23, 30, 8, 32, 41, 1, 15};
        HeapSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
