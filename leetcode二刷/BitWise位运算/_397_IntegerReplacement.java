package leetcode二刷.BitWise位运算;
/**
 * Description: TODO
 * Package Name : leetcode.BitWise位运算;
 * File name : IntegerReplacement397;
 * Creator: Kane;
 * Date: 7/27/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 */

/**
 * n = 2k + 1;
 * n + 1 = (2k + 2) / 2 = k + 1;
 * n - 1 = 2k / 2 = k;
 * 所以%4得到最优解
 * 要考虑3的特殊情况
 */
public class _397_IntegerReplacement {
    public int integerReplacement(int n) {
        /**
         * MAX_VALUE = 2^31 - 1;需要32次
         */
        int res = 0;
        if (n == Integer.MAX_VALUE) return 32;
        while (n != 1) {
            if (n % 2 ==0) {
                n /= 2;
            } else{
                if((n + 1) % 4 == 0 && (n - 1 != 2)) {
                    n++;
                } else {
                    n--;
                }

            } res++;

        }return res;
    }
}

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: BitWise
 * 9 = 1001
 *9 -> 10 5 4 2 1
 *  -> 8 4 2 1
 * 如果倒数第二位是0，那么n-1的操作比n+1得操作能消掉更多的1
 * 9 = 1001 + 1 = 1010 = 10
 * 9 = 1001 - 1 = 1000 = 8
 * 如果倒数第二位是1，那么n+1的操作比n-1得操作能消掉更多的1
 * 11 = 1011 + 1 = 1100 = 12
 * 1001 - 1 = 1000 = 8
 * 但是3是例外
 * 3 = 11;
 * 3 -> 4 -> 2 -> 1
 *   -> 2 -> 1
 */
class IntegerReplacementII{
    public static int intgerReplacement(int n) {
        int res = 0;
        long N = n;
        while (N != 1){
            if (N % 2 == 0) {
                N >>= 1;

            } else {
                if(N == 3) {
                    res +=2;
                    break;
                } N = (N & 2) == 2 ? N+1 : N -1;

            }
            res++;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(intgerReplacement(8));

    }
}
