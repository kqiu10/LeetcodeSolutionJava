package DP动态规划.实现题;
/**
 * Date: 10/28/20
 * Question Description
 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 Example:
 Input: 3
 Output:
 [
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
 ]
 Explanation:
 The above output corresponds to the 5 unique BST's shown below:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */

import Tree.binarySearchTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: DFS
 * Time complexity:O();
 * Space complexity: O();

 */
public class _95_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return getTreeList(1, n);
    }
    public List<TreeNode> getTreeList(int start ,int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = getTreeList(start, idx - 1);
            List<TreeNode> rightList = getTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(idx);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                }
            }
        }
        return list;
    }

}
