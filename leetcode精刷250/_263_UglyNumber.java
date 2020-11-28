/**
 * Date: 11/27/20
 * Question Description
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

 Example 1:

 Input: 6
 Output: true
 Explanation: 6 = 2 × 3
 Example 2:

 Input: 8
 Output: true
 Explanation: 8 = 2 × 2 × 2
 Example 3:

 Input: 14
 Output: false
 Explanation: 14 is not ugly since it includes another prime factor 7.

 */

/**
 * Description: TODO
 * Time complexity:O(1);
 * Space complexity: O(1);

 */
public class _263_UglyNumber { public boolean isUgly(int num) {
    if (num <= 0) return false;
    for (int i = 2; i < 6; i++) {
        while (num % i == 0) {
            num /= i;
        }
    }
    return num == 1;
}

}
