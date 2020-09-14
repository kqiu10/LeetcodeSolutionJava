package src.shape.Square;
/**
 * Package Name : src.shape;
 * File name : Squre;
 * Creator: Kane;
 * Date: 9/14/20
 */

import java.util.HashSet;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Square {

    public int countSquare(List<Point> list) {
        if (list.size() == 0) return 0;
        int res = 0;
        HashSet<Point> set = new HashSet<>();
        for (Point point : list) {
            set.add(point);
        }
        HashSet<String> core = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                if (Math.abs(node1.x - node2.x) != Math.abs(node1.y - node2.y) || node1.equals(node2)) continue;
                Point left = new Point(node2.x, node1.y);
                Point right = new Point(node1.x, node2.y);
                if (set.contains(left) && set.contains(right)) {
                    long dis = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y - right.y);
                    double centerX = (double)(left.x + right.x) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    String info =+ dis + "+" + centerX + "+" + centerY;
                    if (!core.contains(info)) {
                        res++;
                        core.add(info);
                    }
                }
            }
        }
        return res;
    }
}
