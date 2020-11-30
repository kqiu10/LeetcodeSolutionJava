/**
 * Date: 11/29/20
 * Question Description
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        HashSet<String> set = new HashSet<>();

        if (words.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            char a = pattern.charAt(i);
            String b = words[i];
            if (map.containsKey(a)) {
                if (!b.equals(map.get(a))) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }
}
