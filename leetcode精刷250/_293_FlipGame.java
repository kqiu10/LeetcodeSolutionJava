/**
 * Date: 11/30/20
 * Question Description
 You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to compute all possible states of the string after one valid move.

 Example:

 Input: s = "++++"
 Output:
 [
 "--++",
 "+--+",
 "++--"
 ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n^2);
 * Space complexity: O(n);

 */
public class _293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("++")) {
                String cur = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                res.add(cur);
            }
        }
        return res;
    }
}
