package src; /**
 * Date: 11/20/20
 * Question Description
 Given an input string , reverse the string word by word.

 Example:

 Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 Note:

 A word is defined as a sequence of non-space characters.
 The input string does not contain leading or trailing spaces.
 The words are always separated by a single space.
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _186_ReverseWordsInaStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        swap(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i] == ' ') {
                swap(s, start, i - 1);
                start = i + 1;
            }
        }
        swap(s, start, s.length - 1);
        return;

    }
    private void swap(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }

}
