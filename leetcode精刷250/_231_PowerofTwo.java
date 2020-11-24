/**
 * Date: 11/23/20
 * Question Description
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
