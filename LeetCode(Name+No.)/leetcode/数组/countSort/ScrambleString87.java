package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : ScrambleString87;
 * Creator: Kane;
 * Date: 7/30/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */

public class ScrambleString87 {
    public static boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null) return false;
            if (s1.equals(s2)) return true;
            int[] letters = new int[26];
            int len = s1.length();
            for (int i = 0; i < len; i++) {
                letters[s1.charAt(i) - 'a']++;
                letters[s2.charAt(i) - 'a']--;
            }
            for (int letter : letters) {
                if (letter != 0) return false;
            }
            for (int i = 1; i < len; i++) {
                if (isScramble(s1.substring(0,i), s2.substring(0,i))
                        && isScramble(s1.substring(i), s2.substring(i))) return true;
                if (isScramble(s1.substring(0,i), s2.substring(len-i))
                        && isScramble(s1.substring(i), s2.substring(0,len-i))) return true;
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
    }
}
