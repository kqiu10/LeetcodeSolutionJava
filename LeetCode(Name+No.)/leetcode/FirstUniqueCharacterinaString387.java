package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : FirstUniqueCharacterinaString387;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class FirstUniqueCharacterinaString387 {
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
