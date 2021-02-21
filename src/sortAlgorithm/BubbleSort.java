package sortAlgorithm;

import java.util.Arrays;

/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : BableSort;
 * Creator: Kane;
 * Date: 7/18/20
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println((i+1) + " round " + "array is " + Arrays.toString(nums));
            for (int j = nums.length - 1; j >i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;

                }
                System.out.println((i + 1) + " round " + "步骤 " + Arrays.toString(nums));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        bubbleSort(nums);
    }
}
