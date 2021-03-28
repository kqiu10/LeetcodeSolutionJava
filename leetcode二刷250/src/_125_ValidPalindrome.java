/**
 * Date: 3/22/21
 * Question Description:
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters
 * and ignoring cases.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 */

import java.util.Arrays;
import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] res = new int[6];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            int num = (int)(Math.random() * 30) + 1;
            while(!set.add(num)) {
                num = (int)(Math.random() * 30) + 1;
            };
            res[i] = num;
        }
        System.out.println("result is " + Arrays.toString(res));
    }


}
