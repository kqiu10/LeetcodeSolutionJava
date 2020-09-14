package src.shape.Circle;
/**
 * Package Name : src.shape.Circle;
 * File name : Bipartite;
 * Creator: Kane;
 * Date: 9/14/20
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Bipartite {

    public boolean isBitpartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int adjacent : graph[node]) {
                        if (colors[adjacent] == 0) {
                            queue.offer(adjacent);
                            colors[adjacent] = -colors[node];
                        } else if (colors[adjacent] == colors[node]) return false;
                    }
                }
            }
        }
        return true;
    }
}
