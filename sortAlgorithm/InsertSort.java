package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : InsertSort;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class InsertSort {
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println((i+1) + " round " + "array is " + Arrays.toString(nums));
            for (int j = i+1; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
                System.out.println((i+1) + " round " + "步骤 " + Arrays.toString(nums));
            }

        }
    }
    /**
     * Best Time complexity: O(nlogn);
     * Worst Time complexity: O(n^2);
     * Average Time complexity:O(n^2);
     * Space complexity: O(1);
     */
    public static void insertBinarySort(int[] nums) {
        int temp;
        int low;
        int high;
        int mid;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println((i+1) + " round " + "array is " + Arrays.toString(nums));
            temp = nums[i+1];
            low = 0;
            high = i;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j > high; j--) {
                nums[j+1] = nums[j];

            }
            nums[high + 1] = temp;
            System.out.println((i+1) + " round " + "步骤 " + Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
//        insertSort(nums);
        insertBinarySort(nums);
    }
}
