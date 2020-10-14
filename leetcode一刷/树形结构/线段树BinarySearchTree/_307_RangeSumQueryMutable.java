package 树形结构.线段树BinarySearchTree;
/**
 * Date: 10/12/20
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
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _307_RangeSumQueryMutable {
    int[] nums;
    int[] tree;
    int n;
    //time Complexity: O(n * logn)
    public _307_RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    /**
     *
     [1 3 5]
     i = 0 1 2
     nums = 1 3 5
     tree = 0 0 0 0 -> 0 1 0 0 -> 0 1 4 0 -> 0 1 4 5
     diff = 3 5
     j = 2 3
     */
    //time Complexity: O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }

    }
    //time Complexity: O(logn)
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);

    }
    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
