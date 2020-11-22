/**
 * Date: 11/21/20
 * Question Description
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 Example 1:

 Input: [5,7]
 Output: 4
 Example 2:

 Input: [0,1]
 Output: 0

 */

/**
 * Description:
 010001
 010010
 010010
 010011
 最后一位只要有一个0则返回0;
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _201_BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m <<= offset;
    }
}
