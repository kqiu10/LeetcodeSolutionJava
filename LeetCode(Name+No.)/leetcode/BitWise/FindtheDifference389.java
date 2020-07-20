package leetcode.BitWise;
/**
 * Description: 相同字符异或后为0，不同为1，a^b^b = a, 且异或有交换律，所以让s与t中所有字符异或一遍就去除了出现偶数遍的字符，只留下了只出现奇数次的字符;
 * Package Name : leetcode;
 * File name : FindtheDifference389;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class FindtheDifference389 {
    public static char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        System.out.println(c);
        for (int i = 0; i < s.length(); i++) {
             c ^= s.charAt(i);
             c ^= t.charAt(i);

        }
        return c;

    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "ecadb";
        System.out.println(findTheDifference(s,t));
    }

    /**
     * Time complexity:O();
     * Space complexity: O();
     */
    public static class PowerOfTwo {
    }
}
