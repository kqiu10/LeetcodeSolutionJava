package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _422_ValidWordSquare;
 * Creator: Kane;
 * Date: 8/31/20
 */

import java.util.List;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same
 * string, where 0 ≤ k < max(numRows, numColumns).
 *
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 *
 * Input:
 * [
 *   "abcd",
 *   "bnrt",
 *   "crmy",
 *   "dtye"
 * ]
 *
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _422_ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        int row = words.size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= row) return false;
                if (words.get(j).indexOf(i) != words.get(i).indexOf(j)) return false;
            }
        }
        return true;


    }
}
