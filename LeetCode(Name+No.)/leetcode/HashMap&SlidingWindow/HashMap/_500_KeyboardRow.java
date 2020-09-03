package HashMap;
/**
 * Package Name : HashMap;
 * File name : _500_KeyboardRow;
 * Creator: Kane;
 * Date: 9/2/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only
 * one row's of American keyboard like the image below.
 *
 * Time complexity:O(words.length * max(words.length));
 * Space complexity: O(n);
 * Description: TODO
 */
public class _500_KeyboardRow {
    public String[] findWords(String[] words) {

        List<String> res = new ArrayList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> keyboard = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                keyboard.put(c, i);
            }
        }

        for (String word : words) {
            char[] cur = word.toLowerCase().toCharArray();
            int index = keyboard.get(cur[0]);
            boolean sameRow = true;
            for (char c : cur) {
                if (keyboard.get(c) != index) {
                    sameRow = false;
                    break;
                }
            }
           if (sameRow) {
               res.add(word);
           }
        }
        return res.stream().toArray(String[]::new);

    }
}
