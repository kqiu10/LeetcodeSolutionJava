package leetcode.BitWise位运算;
/**
 * Description: TODO
 * Package Name : leetcode.BitWise;
 * File name : MaximumProductOfWordLengths;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 *  convert string to int to compare
 *  val |= 1 << (words[i].charAt(j) - 'a');
 *  |= 等于 +=
 *  "abc"
 *  a : 1 << 0 00001 = 1
 *  b : 1 << 1 00010 = 2
 *  c : 1 << 2 00100 = 4
 *  abc = 1 + 2 + 4 = 7
 */
public class _318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int val;
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < bytes.length; i++) {
            val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;


    }
}
