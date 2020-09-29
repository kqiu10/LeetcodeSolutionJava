package String字符串.basic基础;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _557_ReverseWordsinaStringIII;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _557_ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            str = new StringBuilder(str).reverse().toString();
            System.out.println(str);
            sb.append(str + " ");
        }

        return sb.toString().trim();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
