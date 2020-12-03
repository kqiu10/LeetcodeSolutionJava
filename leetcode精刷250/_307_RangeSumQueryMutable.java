/**
 * Date: 12/3/20
 * Question Description
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.

 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 */

/**
 * Description: BinaryIndexTree
 */
public class _307_RangeSumQueryMutable {
    int[] tree;
    int[] nums;
    int n;
    /**
     * Time complexity:O(nlogn);
     */
    public _307_RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
        /**
         * Time complexity:O(logn);
         */
    }
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= n; j += (j & (-j))) {
            tree[j] += diff;
        }
    }
    /**
     * Time complexity:O(logn);
     */

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int i) {
        int res = 0;
        for (int k = i; k > 0; k -= (k & (-k))) {
            res += tree[k];
        }
        return res;
    }
}
