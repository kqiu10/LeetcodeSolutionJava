package leetcode.BitWise;
/**
 * Description: n & (n-1) 作用： 将n的二进制表示中最低位为1的改为0；
 * Package Name : leetcode.位运算;
 * File name : NumberOf1Bits191;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(1);
 * Space complexity: O(1);
 */
public class NumberOf1Bits191 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
             res += n & i;
             n >>= 1;
            /**
             * 右移一位；
             * 4 : 100;
             * 4 >> 1 : 10 = 2;
             */

        }
        return res;

    }
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res ++;
        }
        return res;

    }
}
