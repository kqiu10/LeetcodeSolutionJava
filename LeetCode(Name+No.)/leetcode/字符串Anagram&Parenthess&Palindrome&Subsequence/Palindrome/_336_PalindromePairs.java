package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _336_PalindromePairs;
 * Creator: Kane;
 * Date: 9/6/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given
 * list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 *
 * Time complexity:O(n * max(word.length) ^ 2;
 * Space complexity: O(n);
 * Description:
 *
 */
public class _336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rev) && map.get(s2rev) != i) {
                        res.add(Arrays.asList(map.get(s2rev), i));
                    }
                }
                // add se.length() != 0 to remove duplicate
                if (s2.length() != 0 && isPalindrome(s2)) {
                    String s1rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1rev) && map.get(s1rev) != i) {
                        res.add(Arrays.asList(i, map.get(s1rev)));
                    }
                }
            }
        }
        return res;

    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
