package src; /**
 * Date: 11/28/20
 * Question Description
 There is a fence with n posts, each post can be painted with one of the k colors.
 You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 Return the total number of ways you can paint the fence.
 Note:
 n and k are non-negative integers.

 Example:

 Input: n = 3, k = 2
 Output: 6
 Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

 post1  post2  post3
 -----      -----  -----  -----
 1         c1     c1     c2
 2         c1     c2     c1
 3         c1     c2     c2
 4         c2     c1     c1
 5         c2     c1     c2
 6         c2     c2     c1

 */

/**
 * Description:
 * 不同 : (k - 1) * total
 * 相同 2 3 相同， 1和2不同的种类
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _276_PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = 0, diff = k, total = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = same + diff;
        }
        return total;
    }
}
