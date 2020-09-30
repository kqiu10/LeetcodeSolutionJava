/**
 * Date: 9/30/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class test {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;

    }

    public static void main(String[] args) {
        reverseBits(28);
    }
}