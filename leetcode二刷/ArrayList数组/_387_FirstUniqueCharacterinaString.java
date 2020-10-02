package leetcode.数组;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : _387_FirstUniqueCharacterinaString;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(n);
 * Space complexity: O(1); //26个字母的空间可数。
 * 相似题目
 * 383 Ransom Note;
 * 242 Valid Anagram
 * 49 Group Anagrams
 */
public class _387_FirstUniqueCharacterinaString {
    public static int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String str = new String("leetcode");
        firstUniqChar(str);
    }
}
