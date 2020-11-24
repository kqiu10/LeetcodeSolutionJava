/**
 * Date: 11/23/20
 * Question Description
 Given an integer n, return true if it is a power of two. Otherwise, return false.

 An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

/**
 * Description: TODO
 * Time complexity:O(1);
 * Space complexity: O(1);

 */
public class _231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }
}
