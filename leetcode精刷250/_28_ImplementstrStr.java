/**
 * Date: 11/3/20
 * Question Description
 Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.

 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Example 3:

 Input: haystack = "", needle = ""
 Output: 0
 */

/**
 * Description: TODO
 * Time complexity:O(len2 * (len1 - len2));
 * Space complexity: O(1);

 */
public class _28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int index = -1;
        int len2 = needle.length(), len1 = haystack.length();
        if (len1 < len2) return -1;
        for (int i = 0; i < len1 - len2 + 1; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return index;
    }
}
