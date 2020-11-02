package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _395_LongestSubstringwithAtLeastKRepeatingCharacters;
 * Creator: Kane;
 * Date: 9/4/20
 */

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters
 * only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int res = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }
    private static int helper(String s, int k, int numUniqueTarget) {
        int[] count = new int[128];
        int start = 0, end = 0;
        int numUnique = 0, numNoLessThanK = 0;
        int res = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnique++;
            if (count[s.charAt(end++)] == k) numNoLessThanK++;

            while (numUnique > numUniqueTarget) {
                if (count[s.charAt(start)]-- == k) numNoLessThanK--;
                if (count[s.charAt(start++)] == 0) numUnique--;
            }
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        longestSubstring("aaabb", 3);
        String s = "Aa";
        System.out.println((int)(s.charAt(0) - 'A'));
        System.out.println((int)(s.charAt(1) - 'a'));
    }

}
