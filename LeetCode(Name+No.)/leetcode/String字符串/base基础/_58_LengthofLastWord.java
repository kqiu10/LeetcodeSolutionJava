package String字符串.base基础;
/**
 * Package Name : String字符串.base基础;
 * File name : _58_LengthofLastWord;
 * Creator: Kane;
 * Date: 8/27/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * Time Complexity of str.split() and String.lastIndexOf() to be O(N)
 * the function String.trim() which returns a copy of the input string without leading and trailing whitespace
 * Therefore, we would need O(N) space for our algorithm to hold this copy.
 */
public class _58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s =s.trim();
        String[] strings = s.split(" ");
        if (strings.length == 0) return 0;
        return strings[strings.length - 1].length();

    }
}
