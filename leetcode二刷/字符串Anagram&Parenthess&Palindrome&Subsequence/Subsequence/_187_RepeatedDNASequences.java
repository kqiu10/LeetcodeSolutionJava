package Subsequence;
/**
 * Description: TODO
 * Package Name : leetcode.BitWise;
 * File name : _187_RepeatedDNASequences;
 * Creator: Kane;
 * Date: 7/21/20
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 */
public class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String window = s.substring(i, i+10);
             if (!set.add(window)) {
                 res.add(window);
             }

        }
        return new ArrayList<>(res);


    }
}
