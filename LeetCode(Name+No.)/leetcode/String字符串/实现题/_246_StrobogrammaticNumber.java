package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _246_StrobogrammaticNumber;
 * Creator: Kane;
 * Date: 9/1/20
 */

import java.util.HashMap;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at
 * upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a
 * string.
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * Example 4:
 *
 * Input: num = "1"
 * Output: true
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
