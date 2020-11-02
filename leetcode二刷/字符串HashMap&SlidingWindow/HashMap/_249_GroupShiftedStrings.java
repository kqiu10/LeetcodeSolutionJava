package HashMap;
/**
 * Package Name : HashMap;
 * File name : _249_GroupShiftedStrings;
 * Creator: Kane;
 * Date: 9/3/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc"
 * -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of non-empty strings which contains only lowercase alphabets, group all strings
 * that belong to the same shifting sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 *
 * Time complexity:O(n * m);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String key = getKey(string);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(string);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());

    }
    private String getKey(String str) {
        char[] c = str.toCharArray();
        String key = "";
        for (int i = 0; i < c.length - 1; i++) {
            int diff = c[i + 1] - c[i];
            key += diff >= 0 ? diff : diff + 26;
            key += ",";
        }
        return key;
    }
}
