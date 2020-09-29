package String字符串.basic基础;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _345_ReverseVowelsofaString;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Time complexity:O(n); because the length pf vowels is known, so the time complexity of indexOf can be considered as O(1);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _345_ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] str = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && vowels.indexOf(str[left]) == -1) left++;
            while (left < right && vowels.indexOf(str[right]) == -1) right--;
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
        return new String(str);
    }
}
