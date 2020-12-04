/**
 * Date: 12/3/20
 * Question Description
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:

 Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 Output: 16
 Explanation: The two words can be "abcw", "xtfn".
 Example 2:

 Input: ["a","ab","abc","d","cd","bcd","abcd"]
 Output: 4
 Explanation: The two words can be "ab", "cd".
 Example 3:

 Input: ["a","aa","aaa","aaaa"]
 Output: 0
 Explanation: No such pair of words.
 */

/**
 * Description: TODO
 * Time complexity:O(n^2);
 * Space complexity: O(n);

 */
public class _318_MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int res = 0;
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int bit = getBit(words[i]);
            bits[i] = bit;
        }
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private int getBit(String str) {
        int res = 0;
        for (char c : str.toCharArray()) {
            res |= 1 << (c - 'a');
        }
        return res;
    }
}
