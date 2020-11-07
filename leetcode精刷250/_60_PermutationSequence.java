/**
 * Date: 11/6/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *      1,  2,  3,  4:
 *      选中最高位后,其他位排列组合个数为n!
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
 * Time complexity:O(n^2);
 * Space complexity: O(n);
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
