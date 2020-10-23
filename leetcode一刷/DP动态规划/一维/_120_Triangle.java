package DP动态规划.一维;
/**
 * Date: 10/23/20
 * Question Description
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

import java.util.List;

/**
 * Description:
 Ex
 [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 i : j
 i + 1 : j, j + 1
 res [0, 0, 0, 0, 0]
      [4, 1, 8, 3]
        [7,6,10]
        [9,10]
          [11]
 * Time complexity:O(n^2);
 * Space complexity: O(n);

 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
