package String字符串.basic基础_实现;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _186_ReverseWordsinaString;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  [ 't ', 'h ', 'e ', '  ', 's ', 'k ', 'y ', '  ', 'i ', 's ', '  ', 'b ', 'l ', 'u ', 'e ']
 * Output: [ 'b ', 'l ', 'u ', 'e ', '  ', 'i ', 's ', '  ', 's ', 'k ', 'y ', '  ', 't ', 'h ', 'e ']
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _186_ReverseWordsinaString {
    public static void reverseWords(char[] s) {
        if (s == null || s.length == 0) {return;}
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;

        }
    }
    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    public static void main(String[] args) {
        reverseWords(new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'});
    }
}
