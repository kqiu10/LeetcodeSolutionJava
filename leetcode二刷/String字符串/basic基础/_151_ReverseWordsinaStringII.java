package String字符串.basic基础;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _151_ReverseWordsinaStringII;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given an input string, reverse the string word by word.
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the
 * reversed string.
 *
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: 正则表达式
 */
public class _151_ReverseWordsinaStringII {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0 || s == null) return s;
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i>=0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
