/**
 * Date: 12/4/20
 * Question Description
 Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 Example 1:

 Input: words = ["abcd","dcba","lls","s","sssll"]
 Output: [[0,1],[1,0],[3,2],[2,4]]
 Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 Example 2:

 Input: words = ["bat","tab","cat"]
 Output: [[0,1],[1,0]]
 Explanation: The palindromes are ["battab","tabbat"]
 Example 3:

 Input: words = ["a",""]
 Output: [[0,1],[1,0]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n * max(len(word) ^ 2);
 * Space complexity: O(m^2);

 */
public class _336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2Rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2Rev) && map.get(s2Rev) != i) {
                        res.add(Arrays.asList(map.get(s2Rev), i));
                    }
                }
                if(s2.length() != 0 && isPalindrome(s2)) {
                    String s1Rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1Rev) && map.get(s1Rev) != i) {
                        res.add(Arrays.asList(i, map.get(s1Rev)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
