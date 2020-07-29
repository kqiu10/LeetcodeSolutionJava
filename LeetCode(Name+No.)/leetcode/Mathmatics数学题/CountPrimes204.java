package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : CountPrimes204;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: 厄拉多塞筛法， 求一组质数，时间复杂度为O（nlognlogn)
 * 如果从1到n-1分别判断质数，时间复杂度为0(nsqrt(n));
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}
