package Tree树.Postorder后序遍历;
/**
 * Date: 10/9/20
 * Question Description
 The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

 Input: [3,2,3,null,3,null,1]

 3
 / \
 2   3
 \   \
 3   1

 Output: 7
 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:

 Input: [3,4,5,1,3,null,1]

 3
 / \
 4   5
 / \   \
 1   3   1

 Output: 9
 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9
 */

import Tree树.TreeNode;


public class _337_HouseRobberIII {
    /**
     * Description: TODO
     * Time complexity:O(n);
     * Space complexity: O(h);
     */
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);

    }
    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
    /**
     * Description: TODO
     * Time complexity:O()很高,不知道;
     * Space complexity: O();
     */
    public int robBFS(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            res += robBFS(root.left.left) + robBFS(root.left.right);
        }
        if (root.right != null) {
            res += robBFS(root.right.left) + robBFS(root.right.left);
        }
        return Math.max(res + root.val, robBFS(root.left) + robBFS(root.right));
    }
}
