package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _340_LongestSubstringwithAtMostKDistinctCharacters;
 * Creator: Kane;
 * Date: 9/4/20
 */

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct
 * characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 *   eceba
 *   j i
 *   num = 2 i-j+1=3
 *   e : 2 c = 1 res = 3
 *   eceba
 *     ji
 *   num = 2 i-j+1=2
 */
public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
