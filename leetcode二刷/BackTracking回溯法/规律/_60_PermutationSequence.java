package leetcode.BackTracking回溯法.规律;
/**
 * Package Name : leetcode.BackTracking回溯法.规律;
 * File name : _60_PermutationSequence;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n
 * = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description:
 *      1,  2,  3,  4:
 *      1  + {2, 3, 4}
 *      2  + {1, 3, 4}
 *      3  + {1, 2, 4}
 *      4  + {1, 2, 3}
 *
 *      18 : 3421
 *      res :
 *      fact : 1 1 2 6
 *
 *      k = 17
 *
 *      i = 4     index = 17 / 6 = 2  k = 17 % 6 = 5
 *      i = 3     index = 5 /  2 = 2  k = 5 % 2 = 1
 *      i = 2     index = 1 / 1 = 1   k = 1 % 1 = 0
 *
 *      4 3 2 1
 *      3 4 2 1
 *
 */
public class _60_PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();

    }
}
