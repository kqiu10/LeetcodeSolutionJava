package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : _370_RangeAddition;
 * Creator: Kane;
 * Date: 8/9/20
 */

/**
 * Time complexity:O(k + n);
 * Space complexity: O(n);
 * Description: 时间复杂度说明：先标记k次， 然后做叠加，所以O(k + n)
 */
public class _370_RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0], end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];

        }
        return res;
    }
}
