package String字符串.basic基础_实现;
/**
 * Package Name : String字符串.base基础;
 * File name : _14_LongestCommonPrefix;
 * Creator: Kane;
 * Date: 8/27/20
 */

/**
 * Time complexity:O(strs[0].length() * strs.length);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length () || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
