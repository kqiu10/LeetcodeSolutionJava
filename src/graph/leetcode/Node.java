package src.graph.leetcode;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description:
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
