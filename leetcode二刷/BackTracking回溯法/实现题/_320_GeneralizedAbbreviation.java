package leetcode.BackTracking回溯法.实现题;
/**
 * Date: 9/16/20
 * Question Description
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Note: The order of the output does not matter.
 *
 * Example:
 *
 * Input: "word"
 * Output:

 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity:O(2^n);
 * Space complexity: O(n);不确定
 * Description:
 * Input: "word"
 * 输出顺序 [4, 3d, 2r1, 2rd, 1o2, 1o1d, 1or1, w3, w2d, w1r1, w1rd, wo2, wo1d, wor1, word2]
 */
public class _320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) return res;
        helper(res, word, 0, "", 0);
        return res;
    }

    private void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        }
        helper(res, word, pos + 1, cur, count + 1);
        helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
    }

    public static void main(String[] args) {

    }

}
