package src; /**
 * Date: 11/28/20
 * Question Description
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 */

import java.util.Arrays;


public class _274_HIndex {
    /**
     * Description: TODO
     * Time complexity:O(nlogn);
     * Space complexity: O(1);
     */
    public int hIndex(int[] citations) {
        int res = citations.length;
        Arrays.sort(citations);
        for (int citation : citations) {
            if (citation < res) {
                res--;
            }
        }
        return res;
    }
    /**
     * Description: TODO
     * Time complexity:O(n);
     * Space complexity: O(n);
     */
    public int hIndexII(int[] citations) {
        int[] helper = new int[citations.length + 1];
        int res = 0;
        for (int citation : citations) {
            if (citation < citations.length) {
                helper[citation]++;
            } else {
                helper[citations.length]++;
            }
        }
        for (int i = citations.length; i >= 0; i--) {
            res += helper[i];
            if (res >= i) {
                return i;
            }
        }
        return 0;
    }
}
