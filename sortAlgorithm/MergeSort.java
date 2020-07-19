package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : MergeSort;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O(nlogn);
 * Worst Time complexity: O(nlogn);
 * Average Time complexity:O(nlogn);
 * Space complexity: O(n);
 * stable
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
        return nums;

    }
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums[low + l] = temp[l];
        }
        System.out.println("当前排序结果 " + Arrays.toString(temp));
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        mergeSort(nums, 0, nums.length - 1);
    }
}
