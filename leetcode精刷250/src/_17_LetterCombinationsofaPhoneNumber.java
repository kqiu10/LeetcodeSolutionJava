package src; /**
 * Date: 11/3/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class _17_LetterCombinationsofaPhoneNumber {
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
     * Description: BackTracking
     * Since string is immutable we don't need delete digit
     * Time complexity:O(3 ^ n);
     * Space complexity: O(n ^ 3);
     */
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
        String letters  = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, cur + letters.charAt(i), index + 1);
        }
    }

    /**
     * Time complexity:O(3^n);
     * Space complexity: O(n);
     * Description : LinkedList is like queue, first in first out
     * Ex "23"  element in linkedlist : "" -> c b a -> af ae ad c b -> bf be bd af ae ad c ->
     *                                  cf ce cd bf be bd af ae ad
     */
    public List<String> letterCombinationsII(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (res.peek().length() == i) {
                String t = res.remove();
                for (Character s : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    String cur = t + s;
                    res.add(cur);
                }
            }
        }
        return res;

    }
}
