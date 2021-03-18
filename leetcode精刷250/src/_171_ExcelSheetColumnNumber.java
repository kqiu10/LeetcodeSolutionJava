package src; /**
 * Date: 11/19/20
 * Question Description
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 */

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(1);

 */
public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + ((s.charAt(i) - 'A') + 1);
        }
        return res;

    }
}
