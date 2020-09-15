package String字符串.实现题;
/**
 * Package Name : String字符串.实现;
 * File name : _520DetectCapital;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _520DetectCapital {
    public boolean detectCapitalUse(String word) {
        int numUpper = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                numUpper++;
            }
        }
        if (numUpper == 1) {
            return Character.isUpperCase(word.charAt(0));
        }
        return numUpper == 0 || numUpper == word.length();
    }
}
