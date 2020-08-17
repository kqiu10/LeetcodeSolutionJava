package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : PermutationinString567;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * 相似题目：76 Minimum Window Substring
 */
public class PermutationinString567 {
    public static boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (int i = 0, j = 0; i < s2.length(); i++) {
            if (--count[s2.charAt(i)] < 0 ) {
                while (count[s2.charAt(i)] != 0) {
                    count[s2.charAt(j++)]++;
                }
            } else if ((i - j + 1) == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }
}
