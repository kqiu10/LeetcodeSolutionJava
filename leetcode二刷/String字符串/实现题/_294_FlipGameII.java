package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _294_FlipGameII;
 * Creator: Kane;
 * Date: 9/2/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(2^n);
 * Space complexity: O(2^n);
 * Description: TODO
 */
public class _294_FlipGameII {
    public static boolean canWin(String s) {
        if (s.length() == 0 || s == null) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return isWin(s, map);

    }
    private static boolean isWin(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!isWin(opponent, map)) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        canWin("++++");
    }
}
