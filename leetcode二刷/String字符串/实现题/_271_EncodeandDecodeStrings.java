package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _271_EncodeandDecodeStrings;
 * Creator: Kane;
 * Date: 8/31/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent
 * over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Time complexity:O(讨论); indexOf take O(m * n), substring take O(n)
 * Space complexity: O(讨论);
 * Description:
 * Ex
 *   ["kevin"] encode => "5/"kevin"
 *             decode => ["kevin"]
 */
public class _271_EncodeandDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int k = 0;
        while (k < s.length()) {
            int slash = s.indexOf('/', k);
            int size = Integer.valueOf(s.substring(k, slash));
            res.add(s.substring(slash + 1, slash + 1 + size));
            k = slash + 1 + size;
        }
        return res;

    }
}
