/**
 * Date: 11/30/20
 * Question Description
 You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 Example:

 Input: s = "++++"
 Output: true
 Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */

import java.util.HashMap;

/**
 * Description: TODO
 * Time complexity:O(2^n);
 * Space complexity: O(2^n);

 */
public class _294_FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return isWin(s, map);
    }

    private boolean isWin(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                if (!isWin(opponent, map)) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
