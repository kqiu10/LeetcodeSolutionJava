package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : SelectSort;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O(n^2);
 * Worst Time complexity: O(n^2);
 * Average Time complexity:O(n^2);
 * Space complexity: O(1);
 * Unstable
 */
public class SelectSort {
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            System.out.println((i+1) + " round " + "array is " + Arrays.toString(nums));
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if ( i != minIndex) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
            System.out.println((i+1) + " round " + "步骤 " + Arrays.toString(nums));

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        selectSort(nums);
    }

}
