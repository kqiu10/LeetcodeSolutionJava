package Tree树;
/**
 * Date: 10/5/20
 * Question Description
 */

import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
}
