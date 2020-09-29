package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : _528_RandomPickwithWeight;
 * Creator: Kane;
 * Date: 8/14/20
 */

import java.util.Random;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _528_RandomPickwithWeight {
    Random rnd;
    int[] sum;

    public _528_RandomPickwithWeight(int[] w) {
        this.rnd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;

    }

    public int pickIndex() {
        int index = rnd.nextInt(sum[sum.length - 1] + 1);
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int pivot = (right - left) / 2 + left;
            if (index < sum[pivot]) right = pivot;
            else left = pivot + 1;
        }
        return left;

    }
}
