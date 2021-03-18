package src; /**
 * Date: 11/21/20
 * Question Description
 Count the number of prime numbers less than a non-negative number, n.

 Example 1:

 Input: n = 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 Example 2:

 Input: n = 0
 Output: 0
 Example 3:

 Input: n = 1
 Output: 0
 */

/**
 * Time complexity:O(nlognlogn);
 * Space complexity: O(nlognlogn);
 * Description: 厄拉多塞筛法， 求一组质数，时间复杂度为O（nlognlogn)
 * 如果从1到n-1分别判断质数，时间复杂度为0(nsqrt(n));
 */
public class _204_CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
