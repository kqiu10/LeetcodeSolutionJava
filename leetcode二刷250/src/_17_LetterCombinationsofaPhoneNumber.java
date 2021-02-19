/**
 * Date: 2/18/21
 * Question Description:
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 that the number could represent. Return the answer in any order.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Note that 1 does not map to any letters.

 * Examples:
 Example 1:

 Input: digits = "23"
 Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 Example 2:

 Input: digits = ""
 Output: []
 Example 3:

 Input: digits = "2"
 Output: ["a","b","c"]
 */

import java.util.ArrayList;
import java.util.List;



public class _17_LetterCombinationsofaPhoneNumber {
    /**
     * Time Complexity: O(3^n)
     * Space Complexity: O(n^3)
     * backtracking
     */
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, digits, "", 0);
        return res;
    }
    private void helper(List<String> res, String digits, String cur, int index) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, cur + letters.charAt(i), index + 1);
        }
    }

    /**
     * Time Complexity: O(3^n)
     * Space Complexity: O(n^3)
     * backtracking
     */
}
