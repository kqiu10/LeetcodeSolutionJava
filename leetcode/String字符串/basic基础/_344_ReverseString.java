package String字符串.basic基础;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _344_ReverseString;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _344_ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
