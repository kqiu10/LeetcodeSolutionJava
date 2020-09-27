package src.graph.skills;
/**
 * Date: 9/27/20
 * Question Description
 */

import src.graph.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class DodirectionalBFS {

    public int DodirectionalBFS(GraphNode start, GraphNode end) {
        Queue<GraphNode> startQueue = new LinkedList<>();
        HashSet<GraphNode> startVisited = new HashSet<>();
        startQueue.offer(start);
        startVisited.add(start);

        Queue<GraphNode> endQueue = new LinkedList<>();
        HashSet<GraphNode> endVisited = new HashSet<>();
        endQueue.offer(start);
        endVisited.add(start);

        int res = 0;

        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            res++;
            for (int i = 0; i < startSize; i++) {
                GraphNode cur = startQueue.poll();
                for (GraphNode neighbor : cur.getNeighbors()) {
                    if (endVisited.contains(neighbor)) {
                        return res;
                    }
                    if (!startVisited.contains(neighbor)) {
                        startVisited.add(neighbor);
                        startQueue.offer(neighbor);
                    }
                }
            }

            int endSize = endQueue.size();
            res++;
            for (int i = 0; i < endSize; i++) {
                GraphNode cur = endQueue.poll();
                for (GraphNode neighbor : cur.getNeighbors()) {
                    if (endVisited.contains(neighbor)) {
                        return res;
                    }
                    if (!endVisited.contains(neighbor)) {
                        endVisited.add(neighbor);
                        endQueue.offer(neighbor);
                    }
                }
            }
        }
        return -1;
    }
}
