package src; /**
 * Date: 12/10/20
 * Question Description
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Follow up: Do not use any built-in library function such as sqrt.



 Example 1:

 Input: num = 16
 Output: true
 Example 2:

 Input: num = 14
 Output: false
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
