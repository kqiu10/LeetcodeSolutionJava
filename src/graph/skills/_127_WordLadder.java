package src.graph.skills;
/**
 * Date: 9/27/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _127_WordLadder {
    class Graph {
        List<Node> nodes;
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNode(Node node) {
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }
    }

    class Node{
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }
}
