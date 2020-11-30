/**
 * Date: 11/29/20
 * Question Description
 The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.

 For example:

 dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
 internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
 it --> it because any word with only two characters is an abbreviation of itself.
 Implement the ValidWordAbbr class:

 ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
 boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
 There is no word in dictionary whose abbreviation is equal to word's abbreviation.
 For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _288_UniqueWordAbbreviation {
    static HashMap<String, String> map;

    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();

        for (String word : dictionary) {
            String abbrev = abbrev(word);
            if (map.containsKey(abbrev)) {
                if (!map.get(abbrev).equals(word)) {
                    map.put(abbrev, "");
                }
            } else {
                map.put(abbrev, word);
            }
        }
    }

    private static String abbrev(String str) {
        if (str.length() <= 2) return str;
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        sb.append(str.charAt(0));
        sb.append(len - 2 + "");
        sb.append(str.charAt(len - 1));
        return sb.toString();
    }

    public static boolean isUnique(String word) {
       return !map.containsKey(abbrev(word)) || map.get(abbrev(word)).equals(word);
    }


    public static void main(String[] args) {
        _288_UniqueWordAbbreviation test = new _288_UniqueWordAbbreviation(new String[]{"deer", "door", "cake", "card"});
        isUnique("cart");
    }
}
