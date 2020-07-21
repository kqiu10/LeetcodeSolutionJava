package leetcode.BitWise;
/**
 * Description: TODO
 * Package Name : leetcode.BitWise;
 * File name : ReverseBits190;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(1);
 * Space complexity: O(1);
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i< 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;

    }
}
