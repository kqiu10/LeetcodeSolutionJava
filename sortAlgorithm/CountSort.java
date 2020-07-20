package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : CountSort;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O(n);
 * Worst Time complexity: 无意义；
 * Average Time complexity:O(n + k); K : 整数范围
 * Space complexity: O(k); K : 整数范围
 */
public class CountSort {
    private static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] array = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]] += 1;
        }
        System.out.println(Arrays.toString(array));
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < array[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 3, 4, 10};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }
}
