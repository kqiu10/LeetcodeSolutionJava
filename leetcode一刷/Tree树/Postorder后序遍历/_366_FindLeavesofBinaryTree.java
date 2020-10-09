package Tree树.Postorder后序遍历;
/**
 * Date: 10/9/20
 * Question Description
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:

 Input: [1,2,3,4,5]

 1
 / \
 2   3
 / \
 4   5

 Output: [[4,5,3],[2],[1]]
 Explanation:

 1. Removing the leaves [4,5,3] would result in this tree:
 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:
 1
 3. Now removing the leaf [1] would result in the empty tree:
 []
 [[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers since per each level it doesn't matter the order on which elements are returned.
 */

import Tree树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _366_FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;

    }

    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
