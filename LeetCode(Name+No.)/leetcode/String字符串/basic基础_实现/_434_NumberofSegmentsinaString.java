package String字符串.basic基础_实现;
/**
 * Package Name : String字符串.base基础;
 * File name : _434_NumberofSegmentsinaString;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Time complexity:O(n); s.trim() takes O(n) time Complexity
 * Space complexity: O(1);
 * Description: TODO
 */
public class _434_NumberofSegmentsinaString {
    public int countSegments(String s) {
        s =s.trim();
        if (s == null || s.length() == 0) return 0;
        String[] res = s.split("\\s+");
        return res.length;

    }
}
