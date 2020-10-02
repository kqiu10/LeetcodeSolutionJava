package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : _205_IsomorphicStrings;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: HashMap;
 * HashMap containsValue Time Complexity O(n);
 */
public class _205_IsomorphicStrings {
    public static  boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b)) {
                    map.put(a,b);
                } else {return false;}
            }
        }
        return true;

    }

    public static void main(String[] args) {
        isIsomorphic("ab", "aa");
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: CountSort;
 */

class IsomorphicStringsII{
    public static boolean isIsomorphic(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }

        }
        return true;

    }
    public static void main(String[] args) {
        isIsomorphic("egg", "add");
    }

}
