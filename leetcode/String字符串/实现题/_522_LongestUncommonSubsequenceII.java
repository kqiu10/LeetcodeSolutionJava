package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _522_LongestUncommonSubsequenceII;
 * Creator: Kane;
 * Date: 8/30/20
 */

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The
 * longest uncommon subsequence is defined as the longest subsequence of one of these strings and
 * this subsequence should not be any subsequence of the other strings.
 *
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters
 * without changing the order of the remaining elements. Trivially, any string is a subsequence
 * of itself and an empty string is a subsequence of any string.
 *
 * The input will be a list of strings, and the output needs to be the length of the longest
 * uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 *
 * Time complexity:O(n^2 * max(s, t));
 * Space complexity: O(1);
 * Description:
 */
public class _522_LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
    private boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
