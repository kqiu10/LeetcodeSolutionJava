package leetcode.ArrayList数组.countSort;
/**
 * Package Name : leetcode.ArrayList数组.countSort;
 * File name : _841_KeysandRooms;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.List;
import java.util.Stack;

/**
 * Time complexity:O(n + e); where n is the number of rooms, and e is the total number of keys.
 * Space complexity: O(n);
 * Description: TODO
 */
public class _841_KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()) {
            int index = stack.pop();
            for (int room : rooms.get(index)) {
                if (visited[room]) continue;
                stack.push(room);
                visited[room] = true;
            }
        }
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }
}
