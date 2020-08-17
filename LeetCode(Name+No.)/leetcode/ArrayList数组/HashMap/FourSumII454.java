package 数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : FourSumII454;
 * Creator: Kane;
 * Date: 8/5/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description:
 * a + b + c + d = 0 == a + b = -c - d;
 */
public class FourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a +b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = -c-d;
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}
