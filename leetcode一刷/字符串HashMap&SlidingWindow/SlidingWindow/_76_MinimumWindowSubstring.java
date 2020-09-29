package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _76_MinimumWindowSubstring;
 * Creator: Kane;
 * Date: 9/4/20
 */

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Time complexity:O();
 * Space complexity: O();
 * Description:
 * test case :
 * S = "ADOBECODEBANC"
 * T = "ABC"
 *
 * ADOBEC
 * DOBECODEBA
 * OBECODEBA
 * BECODEBA
 * ECODEBA
 * CODEBA
 * ODEBANC
 * EBANC
 * BANC
 *
 *         A B C D E F G H ... O
 * COUNT:  0 -1 0 -2 -2         -2
 *
 * A D O B E C O D E B A N C
 *           i                  min = 6 from = 0;
 *   j                          total = 1
 *                     i        min = 11 from = 0
 *           j         i
 */
public class _76_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);

    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
