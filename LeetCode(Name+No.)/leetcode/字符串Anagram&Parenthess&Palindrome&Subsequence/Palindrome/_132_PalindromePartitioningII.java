package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _132_PalindromePartitioningII;
 * Creator: Kane;
 * Date: 9/6/20
 */

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n^2);
 * Description: TODO
 */
public class _132_PalindromePartitioningII {
    public static int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && ((i - j <= 2) || isPalindrome[i-1][j+1])) {
                    isPalindrome[i][j] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[len - 1];
    }

    public static void main(String[] args) {
        minCut("abbab");
    }
}
