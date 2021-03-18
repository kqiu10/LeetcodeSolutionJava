package src; /**
 * Date: 12/5/20
 * Question Description
 Given a string, find the length of the longest substring T that contains at most k distinct characters.

 Example 1:

 Input: s = "eceba", k = 2
 Output: 3
 Explanation: T is "ece" which its length is 3.
 Example 2:

 Input: s = "aa", k = 1
 Output: 2
 Explanation: T is "aa" which its length is 2.
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _340_LongestSubstringwtihAtMostKDinstinceCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] words = new int[128];
        int res = 0;
        int num = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (words[s.charAt(i)]++ == 0) num++;
            while (num > k) {
                if (--words[s.charAt(j++)] == 0) {
                    num--;
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
