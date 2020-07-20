package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : BucketSort;
 * Creator: Kane;
 * Date: 7/19/20
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * n:待排序数据， m : 桶；
 * Best Time complexity: O(n);
 * Worst Time complexity: 无意义
 * Average Time complexity:O(n + c); c = n * (logn ~logm)
 * Space complexity: O(n + m);
 * 稳定
 */
public class BucketSort {
    public static void bucketSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                res[index++] = bucket.get(i).get(j);
            }
        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8, 20};
        bucketSort(nums);
    }
}
