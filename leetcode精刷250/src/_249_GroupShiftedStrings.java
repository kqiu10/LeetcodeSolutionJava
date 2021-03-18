package src; /**
 * Date: 11/26/20
 * Question Description
 Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 Example:

 Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Output:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n * m);
 * Space complexity: O(n);

 */
public class _249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strings) {
            String convert = convertStr(str);
            List<String> list = map.getOrDefault(convert, new ArrayList<>());
            list.add(str);
            map.put(convert, list);
        }
        res.addAll(map.values());
        return res;
    }
    private String convertStr(String str) {
        String num = "";
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i - 1);
            num += diff >= 0 ? diff : diff + 26;
            num += ",";
        }
        return num;
    }
}
