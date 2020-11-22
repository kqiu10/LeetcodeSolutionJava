/**
 * Date: 11/21/20
 * Question Description
 Write an algorithm to determine if a number n is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Return True if n is a happy number, and False if not.

 Example:

 Input: 19
 Output: true
 Explanation:
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 */

import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _202_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int remain, squareSum;
        while (set.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += (remain * remain);
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }
}
