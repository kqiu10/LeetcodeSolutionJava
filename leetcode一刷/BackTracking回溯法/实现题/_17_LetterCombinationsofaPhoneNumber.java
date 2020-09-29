package leetcode.BackTracking回溯法.实现题;
/**
 * Date: 9/16/20
 * Question Description
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O(3^n);
 * Space complexity: O(n^3);
 * Description: TODO
 */
public class _17_LetterCombinationsofaPhoneNumber {
    private static String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res,digits, "", 0);
        return res;

    }

    private static void helper(List<String> res, String digits, String str, int index) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, str + letters.charAt(i), i + 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}


/**
 * Time complexity:O(3^n);
 * Space complexity: O(n);
 * Description: TODO
 */
class LetterCombinationsofaPhoneNumberII {
    public  static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            String num = mapping[digits.charAt(i) - '0'];
            while (res.peek().length() == i) {
                String cur = res.remove();
                for (Character letter : num.toCharArray()) {
                    res.add(cur + letter);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}