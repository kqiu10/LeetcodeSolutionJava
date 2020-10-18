package 设计题.HashMap;
/**
 * Date: 10/18/20
 * Question Description
 An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 ↓
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 ↓   ↓    ↓    ↓  ↓
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 ↓   ↓    ↓
 d) l|ocalizatio|n          --> l10n

 Additionally for any string s of size less than or equal to 2 their abbreviation is the same string s.
 Find whether its abbreviation is unique in the dictionary. A word's abbreviation is called unique if any of the following conditions is met:

 There is no word in dictionary such that their abbreviation is equal to the abbreviation of word.
 Else, for all words in dictionary such that their abbreviation is equal to the abbreviation of word those words are equal to word.


 Example 1:

 Input
 ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
 [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
 Output
 [null, false, true, false, true]

 Explanation
 ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 validWordAbbr.isUnique("dear"); // return False
 validWordAbbr.isUnique("cart"); // return True
 validWordAbbr.isUnique("cane"); // return False
 validWordAbbr.isUnique("make"); // return True
 */

import java.util.HashMap;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _288_UniqueWordAbbreviation {
    HashMap<String, String> map;
    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getKey(s);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(s)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, s);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);

    }
    private String getKey(String s) {
        if (s.length() <= 2) return s;
        return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
    }
}
