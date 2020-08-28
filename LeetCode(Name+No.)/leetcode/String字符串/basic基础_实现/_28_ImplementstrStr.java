package String字符串.basic基础_实现;
/**
 * Package Name : String字符串.base基础;
 * File name : _28_ImplementstrStr;
 * Creator: Kane;
 * Date: 8/27/20
 */

/**
 * Time complexity:O(k * (m - k));
 * Space complexity: O(1);
 * Description: TODO
 */
public class _28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        int k = needle.length(), m = haystack.length();
        for (int i = 0; i < m - k; i++) {
            if (haystack.substring(i, k + i).equals(needle)) return i;
        }
        return -1;

    }
}
