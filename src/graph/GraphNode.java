package src.graph;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class GraphNode {
    int label;

    List<GraphNode> neighbors;

    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();

    }
    public List<GraphNode> getNeighbors(){
        return neighbors;
    }
}
