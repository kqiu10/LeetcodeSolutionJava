package String字符串.basic基础;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _556_NextGreaterElementIII;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has
 * exactly the same digits existing in the integer n and is greater in value than n. If no such
 * positive 32-bit integer exists, you need to return -1.
 *
 * Example 1:
 *
 * Input: 12
 * Output: 21
 *
 *
 * Example 2:
 *
 * Input: 21
 * Output: -1
 *
 * Time complexity:O(1); cuz it's only 32-bit integer that is calculated
 * Space complexity: O(1);
 * Description:
 * Ex take two steps
 * 1 2 3 4 7 6 5 5 3 -> 1 2 3 5 7 6 5 4 3 -> 1 3 4 5 3 4 5 6 7
 */
public class _556_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] c = ("" + n).toCharArray();
        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) {
            i--;

        }
        if (i == -1) return -1;
        int j = c.length - 1;
        while (j >= 0 && c[j] <= c[i]) {
            j--;
        }
        swap(c, i, j);
        reverse(c, i+1, c.length - 1);
        long val = Long.parseLong(c.toString());
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }

    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
    private void reverse(char[]c, int a, int b) {
        while (a < b) {
            char temp = c[a];
            c[a++] = c[b];
            c[b--] = temp;
        }
    }
}
