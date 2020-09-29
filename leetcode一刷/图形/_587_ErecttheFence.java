package 图形;
/**
 * Package Name : 图形;
 * File name : _587_ErecttheFence;
 * Creator: Kane;
 * Date: 9/9/20
 */

import java.util.*;

/**
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden.
 * Your job is to fence the entire garden using the minimum length of rope as it is expensive.
 * The garden is well fenced only if all the trees are enclosed.
 * Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
 *
 * Time complexity:O(nlogn); sort
 * Space complexity: O(n); stack and hashset
 * Description: TODO
 */
public class _587_ErecttheFence {
    public int[][] outerTrees(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (stack.size() >= 2 && orientation(points[i], stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        //pop out the last element in the stack
        stack.pop();

        for (int i = points.length - 1; i >= 0; i--) {
            while (stack.size() >= 2 && orientation(points[i], stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        // remove redundant elements from the stack
        HashSet<int[]> set = new HashSet<>(stack);
        return set.toArray(new int[set.size()][]);
    }
    private int orientation(int[] p1, int[] p2, int[] p3) {
        int ori = (p3[0] - p2[0]) * (p2[1] - p1[1]) - (p2[0] - p1[0]) * (p3[1] - p2[1]);
        return ori;
    }
}

