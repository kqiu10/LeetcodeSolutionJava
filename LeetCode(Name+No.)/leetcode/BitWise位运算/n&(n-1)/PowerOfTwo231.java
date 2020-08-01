package leetcode.BitWise位运算;
/**
 * Description: TODO
 * 2 : 10;
 * 4 : 100;
 * 8 : 1000;
 * 16 : 10000;
 *
 * Package Name : leetcode.位运算;
 * File name : PowerOfTwo;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(1);
 * Space complexity: O(1);
 * n : 16 = 10000;
 * n - 1  : 15 = 01111;
 * 14 = 01110
 */
public class PowerOfTwo231 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);



    }

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(15));
    }
}
