package com.google.src;
/**
 * Date: 4/19/21
 * Question Description:
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1
 * into str2 by doing zero or more conversions.
 *
 * In one conversion you can convert all occurrences of one character in str1 to any other
 * lowercase English character.
 *
 * Return true if and only if you can transform str1 into str2.
 * <p>
 * Examples:
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(26)
 */
public class _1153_StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }

    public static void main(String[] args) {
        _1153_StringTransformsIntoAnotherString test = new _1153_StringTransformsIntoAnotherString();
        test.canConvert("aaab", "bbba");
    }
}
