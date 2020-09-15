package Anagram;
/**
 * Package Name : Anagram;
 * File name : _242_ValidAnagram;
 * Creator: Kane;
 * Date: 9/4/20
 */

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: Counting sort
 */
public class _242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(--count[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
